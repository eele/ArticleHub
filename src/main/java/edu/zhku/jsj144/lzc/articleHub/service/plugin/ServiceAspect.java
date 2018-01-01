package edu.zhku.jsj144.lzc.articleHub.service.plugin;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
	@Autowired
	private ArticleHandler articleHandler;

	@Pointcut("execution(* edu.zhku.jsj144.lzc.articleHub.service.CommonService.insertData(..))")
	public void insertDataPoint() {

	}

	@Pointcut("execution(* edu.zhku.jsj144.lzc.articleHub.service.CommonService.updateData(..))")
	public void updateDataPoint() {

	}

	@Pointcut("execution(* edu.zhku.jsj144.lzc.articleHub.service.CommonService.getData(..))")
	public void getDataPoint() {

	}

	@Before("insertDataPoint() || updateDataPoint()")
	public void writeArticleToFile(JoinPoint joinPoint) throws IOException {
		@SuppressWarnings("unchecked")
		Map<String, String> dataMap = (Map<String, String>) joinPoint.getArgs()[0];
		if (dataMap.containsKey("_content")) {
			articleHandler.writeArticleToFile(dataMap.get("aid"), dataMap.get("_content"));
			dataMap.remove("_content");
		}
	}

	@SuppressWarnings("unchecked")
	@AfterReturning(returning="retData", pointcut="getDataPoint()")
	public void readArticleFromFile(JoinPoint joinPoint, Object retData) throws IOException {
		Map<String, String> dataMap = (Map<String, String>) joinPoint.getArgs()[0];
		if (dataMap.containsKey("_content")) {
			List<Map<String, String>> retList = (List<Map<String, String>>) retData;
			for (Map<String, String> data: retList) {
				articleHandler.readArticleFromFile(data.get("aid"), data);
			}
		}
	}
	
	@Before("insertDataPoint()")
	public void setUUID(JoinPoint joinPoint) {
		@SuppressWarnings("unchecked")
		Map<String, String> dataMap = (Map<String, String>) joinPoint.getArgs()[0];
		if (dataMap.containsKey("_randomID")) {
			dataMap.put(dataMap.get("_randomID"), UUID.randomUUID().toString());
		}
	}
}
