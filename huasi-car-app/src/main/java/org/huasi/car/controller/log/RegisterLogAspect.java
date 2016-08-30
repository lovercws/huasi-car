package org.huasi.car.controller.log;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.huasi.car.common.core.exception.LoginException;
import org.huasi.car.log.entity.AppUserRegisterLog;
import org.huasi.car.log.service.AppUserRegisterLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @desc 注册日志切面
 * @author ganliang
 * @version 2016年8月10日 下午1:41:34
 */
@Aspect
@Component
public class RegisterLogAspect {

	private static final Logger log = Logger.getLogger(RegisterLogAspect.class);

	//创建一个线程池
	private static final ExecutorService threadPool = Executors.newCachedThreadPool();
	//gson
	private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	@Autowired
	private AppUserRegisterLogService registerLogService;
	
	/**
	 * 用户注册切面
	 */
	@Pointcut("execution(* org.huasi.car.controller.user.AppUserLoginController.register(..))")
	public void registerPointcut() {
	}

	/**
	 * 注册 环绕通知
	 * @return
	 * @throws LoginException
	 * @throws Throwable
	 */
	@Around("registerPointcut()")
	public Object registerAround(ProceedingJoinPoint joinPoint) throws LoginException {
		// 获得目标方法名
		String name = joinPoint.getSignature().getName();
		log.info("方法--AOP 环绕通知=============>"+name);
		
		Object object = null;
		AppUserRegisterLog registerLog=new AppUserRegisterLog();
		registerLog.setLogCreateTime(new Date());
		registerLog.setLogName(name);
		
		long start = System.currentTimeMillis();
		try {
			object = joinPoint.proceed();
			registerLog.setLogContent(gson.toJson(object));
			
			long end = System.currentTimeMillis();
			log.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms!");
			registerLog.setUsetime((int)(end - start));
			//记录日志
			recordLog(registerLog);
		} catch (Throwable e) {
			long end = System.currentTimeMillis();
			log.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : " + e.getMessage());
			// 将异常抛到全局异常处理器中
			throw new LoginException("登录注册出现异常");
		}
		return object;
	}
	
	/**
	 * 异步线程记录注册日志
	 * @param log
	 */
	public void recordLog(AppUserRegisterLog registerLog){
		log.info("记录用户注册日志...........");
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				registerLogService.addAppuserRegisterLog(registerLog);
			}
		});
	}
}
