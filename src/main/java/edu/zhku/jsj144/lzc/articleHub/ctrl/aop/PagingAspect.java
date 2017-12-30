package edu.zhku.jsj144.lzc.articleHub.ctrl.aop;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import edu.zhku.jsj144.lzc.articleHub.pojo.Page;

@Aspect
@Component
public class PagingAspect {
	@Pointcut("@annotation(edu.zhku.jsj144.lzc.articleHub.ctrl.aop.ControllerPaging)")
	public void controllerAspect() {
	}

	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Parameter[] parameters = method.getParameters();
		int i = 0;
		for (Parameter p: parameters) {
			if (p.getName().equals(method.getAnnotation(ControllerPaging.class).requestParam())) {
				break;
			}
			i++;
		}
		if (i == parameters.length) {
			throw new IllegalArgumentException("Cannot find the requestParam");
		}
		Page page = (Page) joinPoint.getArgs()[i];
		page.setPagebegin(Integer.parseInt(request.getParameter("pb")));
		page.setPagesize(Integer.parseInt(request.getParameter("ps")));
	}
}
