package com.xilou.open.task;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class XmlTask {

	/**
	 * 以配置文件的方式来配置运行时间
	 */
	public void runXml() {
		System.out.println("定时任务之：二、以配置文件来运行:" + new Date());
	}

}
