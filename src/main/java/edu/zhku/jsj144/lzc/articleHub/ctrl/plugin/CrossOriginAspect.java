package edu.zhku.jsj144.lzc.articleHub.ctrl.plugin;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class CrossOriginAspect {
	@Pointcut("@annotation(edu.zhku.jsj144.lzc.articleHub.ctrl.plugin.CrossOrigin)")
	public void controllerAspect() {
	}

	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) {
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
	}
}
