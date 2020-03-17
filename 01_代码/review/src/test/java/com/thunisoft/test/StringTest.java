package com.thunisoft.test;

/**
 * @describe:
 * @author: chenzhen-1
 * @date: 2019-3-13-上午10:04:33
 */
public class StringTest {

	public static void main(String[] args) {
//		String s1 = "abc";
//
//		String s2 = new String("abc");
//
//		String s3 = "ab" + "c";
//
//		String s4 = "ab";
//
//		String s5 = "c";
//
//		String s6 = s4 + s5;
//
//		System.err.println(s1 == s2);// false
//
//		System.err.println(s1 == s3);// true
//
//		System.err.println(s3 == s6);// false
//
//		System.err.println(s3 == s6.intern());// true
//
//		System.err.println(s6 == s6.intern());// false
//
//		System.err.println(s3 == s3.intern());// true

		String s7 = new StringBuilder("go").append("od").toString();
		System.out.println(s7.intern() == s7); //true
		
		String s8 = new StringBuilder("ja").append("va").toString();
		System.out.println(s8.intern() == s8); //true

	}

}
