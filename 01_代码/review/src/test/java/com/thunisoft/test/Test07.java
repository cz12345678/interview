package com.thunisoft.test;

import org.junit.Test;

/**
 * @describe: 
 * @author:  chenzhen-1
 * @date: 2019-4-19-下午9:08:20
 */
public class Test07 {
	
	@Test
	public void main() {	
		
		test();

	}
	
	public void swap(int x,int y){
		int temp = x;
		x = y;
		y = temp;
		System.err.println(x + "\t" + y);
		System.exit(0);
	}
	
	public void test(){
		
		int i = 10;
		int y = 20;
		
		swap(10,20);
		
		System.err.println(i + "\t" + y);
		
	}
	

}
