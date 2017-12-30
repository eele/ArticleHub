package edu.zhku.jsj144.lzc.articleHub.plugin;

import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

@Intercepts({
		@Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class }) })
public class RangeInterceptor implements Interceptor {

	private String concatRangeSql(String sql, Map<String, String> dataMap) {
		StringBuffer rangeSql = new StringBuffer();
		rangeSql.append(sql);
		if (dataMap.containsKey("_orderby")) {
			rangeSql.append(" order by `")
			.append(dataMap.get("_orderby") + "` ")
			.append(dataMap.get("_order"));
		}
		rangeSql.append(" limit ")
		.append(Integer.parseInt(dataMap.get("_pb")) - 1)
		.append(" , ").append(dataMap.get("_ps"));
		
		System.out.println(rangeSql.toString());
		return rangeSql.toString();
	}

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
		BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
		@SuppressWarnings("unchecked")
		Map<String, String> dataMap = ((Map<String, Map<String, String>>) boundSql.getParameterObject()).get("params");
		
		if (dataMap.containsKey("_pb") && dataMap.containsKey("_ps")) {
			String sql = boundSql.getSql();
			
			sql = concatRangeSql(sql, dataMap);
			
			metaStatementHandler.setValue("delegate.boundSql.sql", sql);
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub

	}

}
