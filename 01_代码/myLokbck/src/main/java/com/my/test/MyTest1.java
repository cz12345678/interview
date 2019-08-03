package com.my.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @describe: 
 * @author:  chenzhen-1
 * @date: 2019-8-3-下午2:12:07
 */
public class MyTest1 {
	
	//定义一个全局的记录器，通过LoggerFactory获取
	private final static Logger logger = LoggerFactory.getLogger(MyTest1.class);
	
	public static void main(String[] args) {
		logger.trace("trace logback 成功了");
		logger.debug("debug logback 成功了");
		logger.info("info logback 成功了");
		logger.warn("warn logback 成功了");
		logger.error("error logback 成功了");
		
		
	}
	
	
	

}
