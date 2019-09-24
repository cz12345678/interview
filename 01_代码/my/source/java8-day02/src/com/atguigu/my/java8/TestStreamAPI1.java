package com.atguigu.my.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.atguigu.java8.Employee;

/**
 * 
 * @author chenzhen-1
 * @date 2019年5月13日-下午2:09:52
 * 
 *  一、Stream 的操作步骤
 *  
 *  1. 创建Stream
 * 
 * 	2. 中间操作
 * 
 * 	3.终止操作
 * 
 *
 **/
public class TestStreamAPI1 {
	
	
	List<Employee> emps = Arrays.asList(
			new Employee(102, "李四", 59, 6666.66),
			new Employee(101, "张三", 18, 9999.99),
			new Employee(103, "王五", 28, 3333.33),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55)
	);
	
	
	//2. 中间操作
	/**
	 *  映射
	 *  map--接收Lambda ，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并且映射成一个新的元素
	 *  flatMap--接收一个函数作为参数，将流中的每个值都转换成另一个流，然后把所有的流连接成一个流
	 * 
	 */
	
	@Test
	public void test1() {
		Stream<String> stream = emps.stream()
			.map(Employee::getName);
		stream.forEach(System.out::println);
		
		System.out.println("-------------------------");
		
		List<String> strs = Arrays.asList("aaaaa", "bbbbbbbbb", "cccccccccc", "dddddddddd", "eeeeeeeeee");
		
		Stream<String> upperStrs = strs.stream()
			.map(String::toUpperCase);
		upperStrs.forEach(System.out::println);
		
		System.out.println("-------------------------");
		
		
		Stream<Stream<Character>> ssc = strs.stream()
			.map(TestStreamAPI1::filterCharacter);
		
		ssc.forEach((sm) -> {
			sm.forEach(System.out::println);
		});
		
		System.out.println("--------------------------");
		
		Stream<Character> strCh = strs.stream()
			.flatMap(TestStreamAPI1::filterCharacter);
		
		strCh.forEach(System.out::println);	
		
	}
	
	
	public static Stream<Character> filterCharacter(String str){
		
		
		List<Character> list = new ArrayList<>();
		
		for (Character ch : str.toCharArray()) {
			list.add(ch);
		}
		return list.stream();		
	}
	
	/**
	 * 	sort() -- 自然排序
	 *  sorted(Comparator com) --定制排序 
	 */
	@Test
	public void test2() {
		
		emps.stream()
			.map(Employee::getName)
			.sorted()
			.forEach(System.out::println);
		System.out.println("-----------------");
		
		//需求，先按照年龄排序，如果相同在按照姓名排序
		
		emps.stream()
			.sorted((x, y) -> {
				if (x.getAge() == y.getAge()) {
					return x.getName().compareTo(y.getName());
				}
				return Integer.compare(x.getAge(), y.getAge());
			})
			.forEach(System.out::println);	
	}

}
