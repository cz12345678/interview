package com.thunisoft.test;

import java.util.Locale;
import java.util.Random;

/**
 * @describe: 
 * @author:  chenzhen-1
 * @date: 2019-3-18-下午8:56:51
 */
public class MpSort {
	
	
	
	public static void main(String[] args) {
		int[] arr = new int[10];
		
		for( int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random() * 100);
			
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.err.print(arr[i] + "\t");
		}
		
		System.err.println();
		sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.err.print(arr[i] + "\t");
		}
		
		
		
	}	
	
	public static void sort(int[] arr){
		
		for (int i = 0; i < arr.length - 1; i++){
			
			for (int j = 0; j < arr.length - 1; j++){
				 if( arr[j] > arr[j + 1]){
					 int temp = arr[j];
					 arr[j] = arr[j + 1];
					 arr[j + 1] = temp;
				 }	
				 
			}
			
		}
		
		
	}
	
	
	
	public static void date(){
		
		
		
	}

}
