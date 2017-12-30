package edu.zhku.jsj144.lzc.articleHub.ctrl.aop;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE_PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target({ METHOD, TYPE_PARAMETER })
public @interface ControllerPaging {
	
	public String requestParam();
	
}
