package com.thunisoft.test;

import org.junit.Test;

/**
 * @describe: 
 * @author:  chenzhen-1
 * @date: 2019-2-21-上午11:12:28
 */
public class Test01 {
	
	@Test
	public void test01(){
		System.err.println(test1());
	}

	public int test1(){		
		int i = 0;
		try{
			return i++;
		}
		finally{
			return ++i;			
		}		
	}
	
	
	@Test
	public void test02(){
		System.err.println(test2());
	}
	
	
	public int test2(){
		int i = 0;
		try{
			return i++;
		}
		finally{
			++i;
			System.err.println(i);
		}	
	}
	

}
