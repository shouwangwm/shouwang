package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {

	private final static Logger logger = LoggerFactory
			.getLogger(Provider.class);

	public static void main(String[] args) throws Exception {
		startService();
		logger.warn("服务已启动");
		synchronized (Provider.class) {
			Provider.class.wait();
		}

	}

	static void startService() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"notenv/applicationContext.xml");
		context.start();
	}
}
