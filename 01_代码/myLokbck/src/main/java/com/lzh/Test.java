package com.lzh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test
{
	/**
	 * 日志记录
	 */
	private Logger logger = LoggerFactory.getLogger("traceInfo");
	/**
	 * 目录信息
	 */
	private Logger categoryInfo = LoggerFactory.getLogger("categoryInfo");

	/**
	 * 目录与目录的关联关系
	 */
	private Logger productInfo = LoggerFactory.getLogger("productInfo");

	public void print()
	{
		// 日志记录
		if (logger.isDebugEnabled())
		{
			logger.debug("Entry: print().");
		}
		categoryInfo.info("categoryInfo");
		productInfo.info("productInfo");
		// 日志记录
		if (logger.isDebugEnabled())
		{
			logger.debug("Exit: print().");
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		new Test().print();

	}

}
