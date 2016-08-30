package org.huasi.car.controller.log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.huasi.car.log.entity.MerSearchLog;
import org.huasi.car.log.service.MerSearchLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @desc 商户搜索日志记录切面
 * @author ganliang
 * @version 2016年8月12日 下午4:01:40
 */
@Component
@Aspect
public class MerSearchLogAspect {

	private static final Logger log = Logger.getLogger(MerSearchLogAspect.class);
	// gson
	private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

	// 创建一个线程池
	private static final ExecutorService threadPool = Executors.newCachedThreadPool();

	@Autowired
	private MerSearchLogService searchLogService;

	/**
	 * 全局controller 切面
	 */
	@Pointcut("execution(* org.huasi.car.controller.merchant.MerchantSearchController.search(..))")
	public void searcgLogPointcut() {
	}

	/**
	 * 搜索环绕通知
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("searcgLogPointcut()")
	public Object searchLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
		MerSearchLog searchLog = new MerSearchLog();
		// 设置searchlog 参数
		Object[] args = joinPoint.getArgs();
		if (args != null && args.length == 2) {
			if(args[0]!=null){
				searchLog.setUserId(Integer.parseInt(args[0].toString()));
			}
			searchLog.setSearchContent(args[1].toString());
		}
		// 设置searchLog 方法名称
		String name = joinPoint.getSignature().getName();
		searchLog.setLogName(name);

		long start = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();
		long end = System.currentTimeMillis();

		// searchLog 消费时间
		searchLog.setUsetime((int) (end - start));
		searchLog.setLogContent(gson.toJson(proceed));
		recordSearchLog(searchLog);
		return proceed;
	}

	/**
	 * 记录搜索日志
	 * @param searchLog
	 */
	private void recordSearchLog(MerSearchLog searchLog) {
		log.info("记录用户注册日志...........");
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				searchLogService.addMerSearchLog(searchLog);
			}
		});
	}
}
