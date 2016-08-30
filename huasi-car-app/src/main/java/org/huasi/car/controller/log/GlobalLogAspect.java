package org.huasi.car.controller.log;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @desc 全局日志记录
 * @author ganliang
 * @version 2016年8月12日 下午3:17:24
 */
@Component
@Aspect
public class GlobalLogAspect {

	private static final Logger log = Logger.getLogger(GlobalLogAspect.class);
	// gson
	private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

	/**
	 * 全局controller 切面
	 */
	@Pointcut("execution(* org.huasi.car.controller.*.*Controller.*(..))")
	public void globalPointcut() {
	}

	@Around("globalPointcut()")
	public Object globalAround(ProceedingJoinPoint joinPoint) throws Throwable {
		Signature signature = joinPoint.getSignature();
		log.info("method--->>>" + signature.getDeclaringTypeName() + " " + signature.getName());
		log.info("parameter--->>>" + StringUtils.join(joinPoint.getArgs()));
		long start = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();
		long end = System.currentTimeMillis();
		log.info("result---->>>" + gson.toJson(proceed));
		log.info("usetime ---->>>" + (end - start) + " ms!");
		return proceed;
	}
}
