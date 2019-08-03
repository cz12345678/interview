package com.lzh.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @author: lizhaohua
 * @date: 2016/6/15
 * @version: V1.0
 */
public class DaoTest {
	//定义一个全局的记录器，通过LoggerFactory获取
	private final static Logger logger = LoggerFactory.getLogger(DaoTest.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		logger.trace("trace logback 成功了");
		logger.debug("debug logback 成功了");
		logger.info("info logback 成功了");
		logger.warn("warn logback 成功了");
		logger.error("error logback 成功了");
		int i=0 ;
		try {
			System.out.print(4/0);
		}catch (Exception e){
			logger.error("整数除以0==》{}",e);
		}

	}
}
