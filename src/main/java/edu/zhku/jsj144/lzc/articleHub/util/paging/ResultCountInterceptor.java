package edu.zhku.jsj144.lzc.articleHub.util.paging;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import com.mchange.v2.c3p0.impl.NewProxyPreparedStatement;

import edu.zhku.jsj144.lzc.articleHub.pojo.Page;

@Intercepts({
	@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = { Statement.class }) })
public class ResultCountInterceptor implements Interceptor {

	private int getRecordCount(Invocation invocation, String sql, Object pObj) {
		StringBuilder countSql = new StringBuilder("select count(*) from ");
		sql = sql.toLowerCase().trim();
		String field = sql.substring(sql.indexOf("where") + 6, sql.indexOf("=") - 1);
		countSql.append(sql.substring(sql.indexOf("from") + 5));
		int count = 0;

		PreparedStatement countStmt = null;
		ResultSet rs = null;
		try {
			NewProxyPreparedStatement statement = (NewProxyPreparedStatement) invocation.getArgs()[0];
			Connection connection = statement.getConnection();
			countStmt = connection.prepareStatement(countSql.toString());
			Field f = pObj.getClass().getDeclaredField(field);
			f.setAccessible(true);
			countStmt.setString(1, (String) f.get(pObj));
			rs = countStmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				countStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		ResultSetHandler resultSetHandler = (ResultSetHandler) invocation.getTarget();
		MetaObject metaResultSetHandler = SystemMetaObject.forObject(resultSetHandler);
		MappedStatement mappedStatement = (MappedStatement) metaResultSetHandler.getValue("mappedStatement");

		if (mappedStatement.getResultMaps().size() > 0 && 
				mappedStatement.getResultMaps().get(0).getResultMappings().size() > 0) {
			BoundSql boundSql = (BoundSql) metaResultSetHandler.getValue("boundSql");
			String sql = boundSql.getSql();
			Page page = (Page) boundSql.getParameterObject();
			
			@SuppressWarnings("unchecked")
			List<Page> list = (List<Page>) invocation.proceed();
			if (list.size() > 0) {
				list.get(0).setCount(getRecordCount(invocation, sql, page));
				list.get(0).setPagebegin(page.getPagebegin());
				list.get(0).setPagesize(page.getPagesize());
			}
			return list;
		} else {
			return invocation.proceed();
		}
	}

	@Override
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		if (target instanceof ResultSetHandler) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub

	}

}
