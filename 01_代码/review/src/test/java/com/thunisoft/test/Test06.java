package com.thunisoft.test;

import java.lang.Thread.State;


/**
 * @describe: 
 * @author:  chenzhen-1
 * @date: 2019-2-21-上午11:12:28
 */
public class Test06 {
	public static void main(String[] args) {
		State blocked = Thread.State.BLOCKED;
		System.err.println(blocked);
	}
}
