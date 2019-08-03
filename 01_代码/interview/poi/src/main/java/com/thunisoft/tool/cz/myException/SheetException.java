package com.thunisoft.tool.cz.myException;

/**
 * 
 * @author chenzhen-1
 * @date 2019年7月2日-下午4:55:23
 *
 * Excel标签异常
 **/
public class SheetException extends RuntimeException {

	public SheetException(Throwable e) {
		super(e);
	}
	
	public SheetException(String message) {
		super(message);
	}
	
}
