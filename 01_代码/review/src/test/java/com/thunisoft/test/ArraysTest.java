package com.thunisoft.test;

import java.util.Arrays;

/**
 * @describe: 
 * @author:  chenzhen-1
 * @date: 2019-3-12-下午8:09:48
 */
public class ArraysTest {
	
	public static void main(String[] args) {
		int[] intArr = new int[8];
		
		Arrays.fill(intArr, 8);
		
		int[] copyOf = Arrays.copyOf(intArr, 10);
		System.err.println(intArr == copyOf);
		
		for (int i : intArr) {
			System.err.print(i + "\t");
		}
		
		System.err.println();
		
		for (int i : copyOf){
			System.err.print(i + "\t");
		}

		
	}

}
