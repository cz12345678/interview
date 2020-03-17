package com.thunisoft.test;


/**
 * @describe: 
 * @author:  chenzhen-1
 * @date: 2019-2-21-上午11:12:28
 */
public class Test04 {
	
	public static void main(String[] args){
		System.err.println(dg(10));
	}
	
	public static int dg(int i){
		if ( i <= 1){
			return i;
		}
		return i * dg(--i);
	}
	

}

