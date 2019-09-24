package com.atguigu.my.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.atguigu.java8.Employee;

/**
 * 
 * @author chenzhen-1
 * @date 2019年5月13日-上午10:55:23
 * 
 *  一、Stream API 的操作步骤：
 *  
 *  1. 创建Stream
 *	
 *	2. 中间操作
 *	
 *	3. 终止操作（终端操作）
 **/
public class TestStreamaAPI {
	
	// 1.创建Stream
	@Test
	public void test01() {
		
		//1. Collection 提供了两个方法 stream() 与parallelStream()
		
		List<String> list = new ArrayList<>();
		
		Stream<String> stream = list.stream();//获取一个顺序流
		Stream<String> parallelStream = list.parallelStream();//获取一个并行流
		
		//2. 通过Arrays 中的stream() 获取一个数组流
		
		Integer[] nums = new Integer[10];
		Stream<Integer> stream1 = Arrays.stream(nums);
		
		//3. 通过Stream 类中静态方法of()
		Stream<Integer> stream2 = Stream.of(1,2,3,4,5,6,7,8);
		
		//4. 创建无限流
		//迭代
		Stream<Integer> stream3 = Stream.iterate(0, x -> x + 2).limit(100);
		stream3.forEach(System.out::println);
		
		//生成
		Stream<Double> stream4 = Stream.generate(Math::random);
		stream4.forEach(System.out::println);
		
	}
	
	
	
	//2. 中间操作
	List<Employee> emps = Arrays.asList(
			new Employee(102, "李四", 59, 6666.66),
			new Employee(101, "张三", 18, 9999.99),
			new Employee(103, "王五", 28, 3333.33),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55)
	);
	
	/*
	 *	 筛选和切片 
	 *  filter--接收Lambda ， 从流中排除某些元素
	 *  limit--截断流，使其袁术不超过给定数量
	 *  skip(int n) 跳过元素， 返回一个扔掉了前n 个元素的流。若流中元素不足n 个，则返回一个空流。与limit(n)互补
	 *  distinct--筛选，通过流所生成元素的hashCode() 和 equals() 去重
	 * 
	 */
	//内部迭代： 迭代操作Stream API 内部完成
	@Test
	public void test02() {		
		Stream<Employee> stream = emps.stream()
			.filter(e -> {
				System.out.println(e.getName());
				return e.getAge() <= 35;}
			);	
		
		//只有当做终止操作室，所有的中间操作会一次性的全部执行，称为“惰性求值”
		stream.forEach(System.out::println);		
	}
	
	//外部迭代
	@Test
	public void test3() {
		
		Iterator<Employee> its =  emps.iterator();
		
		while (its.hasNext()) {
			System.out.println(its.next());
		}		
	}
	
	
	@Test
	public void test5() {
		emps.stream()
			.filter(e ->{
				System.out.println("短路！");
				return e.getSalary() >= 5000;
			})
			.limit(3)
			.forEach(System.out::println);			
	}
	
	
	
	@Test
	public void test6() {
		emps.parallelStream()
			.filter(e -> e.getSalary() >= 5000)
			.skip(2)
			.forEach(System.out::println);
				
	}
	
	
	@Test
	public void test7() {
		emps.stream()
			.distinct()
			.forEach(System.out::println);		
	}
	
	
	

}
