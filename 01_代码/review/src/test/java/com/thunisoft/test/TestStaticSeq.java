package com.thunisoft.test;



// Father.java	Son.java	 ---->  *.class
class Father
{
	{
		System.out.println("222222");
	}
	public Father()
	{
		System.out.println("111111");
	}
//	{
//		System.out.println("222222");
//	}
	static{
		System.out.println("333333");
	}
}
class Son extends Father
{
	public Son()
	{
		super();
		
		System.out.println("444444");
	}
	{
		System.out.println("555555");
	}
	static{
		System.out.println("666666");
	}	
}




public class TestStaticSeq
{
	public static void main(String[] args)
	{
		new Son();
//		System.out.println("======================");
//		new Son();
//		System.out.println("======================");
//		new Father();

		
//		String s2 = "java";
//		String s1 = new String("java");
//		String s3 = new String("java");
		
		
		
		
	}
}
