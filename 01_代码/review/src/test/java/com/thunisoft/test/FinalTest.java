package com.thunisoft.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @describe: 
 * @author:  chenzhen-1
 * @date: 2019-3-14-上午11:01:26
 */
public class FinalTest {
	
	public static void main(String[] args) {
		final StringBuilder sb = new StringBuilder("xxx");
		sb.append("xx");
		
//		sb = new StringBuilder();
		
		final int i = 9;
//		i = 10;
	}
	
	public static <T> T cloneObj(T t) throws IOException, SecurityException{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(t);
		
		
		
		return null;
	}

}
