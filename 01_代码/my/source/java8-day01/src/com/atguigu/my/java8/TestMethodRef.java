package com.atguigu.my.java8;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * 一、 方法引用：若Lambda 体重的功能，已经有方法提供了实现，可以使用方法引用
 * 				（可以将方法引用理解为Lambda 表达式的另外一种表现形式）
 * 
 * 	1. 对象的引用::实例方法名
 * 
 * 	2. 类名 :: 静态方法名
 * 
 * 	3. 类名 :: 实例方法名
 * 
 * 	注意：
 * 		①：方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
 * 		②： 若Lambda 的参数列表的第一个参数，是实例方法的调用者，第二个参数（或无参）是实例方法的参数是，格式 ClassName::MethodName
 * 	
 * 二、构造器引用：构造器的参数列表，需要与函数式接口中参数列表保持一致！
 * 	
 * 1. 类名::new
 * 
 * 三、数组引用
 * 	
 * 	类型[] :: new
 * 
 *
 **/
public class TestMethodRef {
	
	
	@Test
	public void test8() {
		
		Function<Integer, String[]> fun = (i) -> new String[i];
		
		Function<Integer, String[]> fun1 = String[]::new;
		
		System.out.println(fun.apply(10).length);
		System.out.println(fun1.apply(10).length);
		
		
		
	}
	
	
	// 构造器引用
	@Test
	public void test7() {
		
		Function<String,Employee> fun = Employee::new;
		
		Employee emp = fun.apply("zhangsan");
		
		System.out.println(emp);
		
		System.out.println("----------------------------");
		
		BiFunction<String, Integer,Employee> bf = Employee::new;
		
		System.out.println(bf.apply("lisi", 67));
		
	}
	
	//构造器引用
	@Test
	public void test6() {
		
		Supplier<Integer> sup = () -> new Integer(22);
		
		System.out.println(sup.get());
		
		Function<Integer,Integer> fun = Integer::new;
		
		System.out.println(fun.apply(33));
	}
	
	
	
	//类名::实例方法名
	//参数与返回值类型一致	
	@Test
	public void test5() {
		BiPredicate<String, String> bp = (x, y) -> x.equals(y);
		
		System.out.println(bp.test("ab", "ab"));
		
		System.out.println("-----------------------------------");
		
		BiPredicate<String, String> bp2 = String::equals;
		
		System.out.println(bp2.test("xx", "yy"));
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxx");
		
		Function<Employee, String> fun = x -> x.getName();
		
		System.out.println(fun.apply(new Employee()));
		
		System.out.println("-------------------------");
		
		Function<Employee, String> fun1 = Employee::getName;
		System.out.println(new Employee("zhangsan"));
		
		
	}
	
	
	// 类名::静态方法名
	@Test
	public void test4() {
		
		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
		System.out.println(com.compare(1,34));
		System.out.println("--------------------------");
		
		Comparator<Integer> com1 = Integer::compare;
		
		System.out.println(com1.compare(12, 2));
		
	}
	
	
	//类名::静态方法名
	//返回值类型与参数列表 保持一致
	
	@Test
	public void test3() {
		
		BiFunction<Integer,Integer,Integer> fun = (x,y) -> Integer.sum(x, y);
		
		System.out.println(fun.apply(100, 200));
		
		System.out.println("--------------------------------");
		
		BiFunction<Integer,Integer,Integer> fun1 = Integer::sum;
		
		System.out.println(fun1.apply(23,78));
		
		
	}
	
	
	//供给型接口的 方法引用
	@Test
	public void test2() {
		
		Employee emp = new Employee(101,"zhangsan",18,9999.99);
		
		Supplier<String> sup = () -> emp.getName();
		System.out.println(sup.get());
		System.out.println("------------------------------");
		
		Supplier<String> sup1 = emp::getName;
		System.out.println(sup1.get());
		
	}
	
	//对象的引用 :: 实例方法名1
	// 实例方法的列表参数和返回值类型与 函数式接口的保持一致
	@Test
	public void test01() {
		
		PrintStream ps = System.out;		
		Consumer<String> con = (str) -> ps.println(str);;
		con.accept("Hello java8");
		
		System.out.println("---------------------------");
		
		Consumer<String> con2 = ps::println;
		
		con2.accept("Hello2 java8");
		
		System.out.println("--------------------------");
		
		Consumer<String> con3 = System.out::println;
		con3.accept("zhangsan");
		
	}

}
