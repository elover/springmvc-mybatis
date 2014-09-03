package com.xilou.open.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Properties;

@Component
public class ClickUpdateTask {

	/**
	 * 每20秒中跑一次，cron参考本包下的cron.txt
	 */
//	@Scheduled(cron = "0/20 * * * * ? ")
//	public void runTask1() {
//		System.out.println("定时任务：1、以注解、cron表达式定义时间：");
//        Properties properties = System.getProperties();
//        System.out.println(properties.getProperty("file.encoding"));
//	}

	/**
	 * 任务执行完成，18秒后再次执行
	 */
	@Scheduled(cron = "0 25 10 29 2 ?")
	void doSomethingWithDelay() {
		System.out.println("定时任务之：1.1、固定延时执行:" + new Date());
	}

	/**
	 * 每隔17秒执行任务
	 */
//	@Scheduled(fixedRate = 17000)
//	void doSomethingWithRate() {
//		System.out.println("定时任务之：1.2、固定频率执行:");
//	}

}
