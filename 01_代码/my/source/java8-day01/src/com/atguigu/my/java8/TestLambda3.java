package com.atguigu.my.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * Java8 内置的四大核心函数式接口
 * 	Consumer<T> : 消费型接口
 * 		void accept(T t)
 * 	
 * 	Supplier<T> : 供给型接口
 * 		T get()
 * 
 * 	Function<T, R> : 函数型接口
 * 		R apply(T t)
 * 
 * 	Predicate<T> : 断言型接口
 * 		boolean test(T t)
 * 
 * 
 *
 **/
public class TestLambda3 {
	
	//Predicate<T> : 断言型接口
	@Test
	public void test4() {
		List<String> strs = Arrays.asList("a","ab","abc","abcd","abcde","abcdef");
		List<String> strList = filterStr(strs,str -> str.length() > 3);
		
		for (String str : strList) {
			System.out.println(str);
		}
		
	}
	
	
	//需求：将满足条件的字符串，放入集合中
	public List<String> filterStr(List<String> strs, Predicate<String> pre){
		List<String> list = new ArrayList<>();
		
		for (String str : strs) {
			if (pre.test(str)) {
				list.add(str);
			}
		}
		return list;
		
	}
	
	// Function<T, R> 函数型接口
	@Test
	public void test3() {
		//转换成大写
		String upperStr = strHandler("aaa", x -> x.toUpperCase());
		System.out.println(upperStr);
		
		//字符串截取
		String subStr = strHandler("Xxxxxxxxxxxxx", x -> x.substring(0, 2));
		System.out.println(subStr);
		
		
	}
	
	
	//需求：用于处理字符串
	public String strHandler(String str, Function<String,String> fun) {
		return fun.apply(str);
	}
	
	
	
	//Supplier<T> 供给型接口
	@Test
	public void test2() {
		
		List<Integer> list = getNumList(20,() -> (int)(Math.random() * 100));
		
		list.stream()
			.forEach(System.out::println);
		
	}
	
	//需求：获取指定个数的整数，并放入集合中
	public List<Integer> getNumList(int num, Supplier<Integer> sup){
		
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < num; i++) {
			list.add(sup.get());			
		}
		return list;
	}
	
	
	//Consumer<T> 消费型接口：
	@Test
	public void test1() {		
		happy(10000, (m) -> System.out.println("老张喜欢大保健，每次消费" + m + "元"));
	}
	
	public void happy(double money, Consumer<Double> con) {
		con.accept(money);
	}

}
