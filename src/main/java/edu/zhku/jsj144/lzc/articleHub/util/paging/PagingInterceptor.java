package edu.zhku.jsj144.lzc.articleHub.util.paging;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import edu.zhku.jsj144.lzc.articleHub.pojo.Page;

@Intercepts({
		@Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class }) })
public class PagingInterceptor implements Interceptor {

	private String concatPageSql(String sql, Page page) {
		StringBuffer pageSql = new StringBuffer();
		pageSql.append(sql);
		pageSql.append(" limit ").append(page.getPagebegin() - 1).append(" , ").append(page.getPagesize());
		return pageSql.toString();
	}

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
		MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
		
		if (mappedStatement.getResultMaps().size() > 0 && 
				mappedStatement.getResultMaps().get(0).getResultMappings().size() > 0) {
			BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
			String sql = boundSql.getSql();
			Page page = (Page) boundSql.getParameterObject();
			sql = concatPageSql(sql, page);
			
			metaStatementHandler.setValue("delegate.boundSql.sql", sql);
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		if (target instanceof StatementHandler) {
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
