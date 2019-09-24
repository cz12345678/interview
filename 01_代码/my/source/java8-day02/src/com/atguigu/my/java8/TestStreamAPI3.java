package com.atguigu.my.java8;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import com.atguigu.java8.Employee;
import com.atguigu.java8.Employee.Status;

/**
 * 
 * @author chenzhen-1
 * @date 2019年5月13日-下午3:28:21
 *
 **/
public class TestStreamAPI3 {
	List<Employee> emps = Arrays.asList(
			new Employee(102, "李四", 79, 6666.66, Status.BUSY),
			new Employee(101, "张三", 18, 9999.99, Status.FREE),
			new Employee(103, "王五", 28, 3333.33, Status.VOCATION),
			new Employee(104, "赵六", 8, 7777.77, Status.BUSY),
			new Employee(104, "赵六", 8, 7777.77, Status.FREE),
			new Employee(104, "赵六", 8, 7777.77, Status.FREE),
			new Employee(105, "田七", 38, 5555.55, Status.BUSY)
	);
	
	
	/**
	 * 	3. 终止操作：
	 * 	规约
	 * 		reduce(T identity, BinaryOperator) / reduce(BinaryOperator)--可以将流中元素反复结合起来，得到一个值
	 */
	
	@Test
	public void test1() {
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		Integer sum = nums.stream()
			.reduce(0,Integer::sum);
		System.out.println(sum);
		
		System.out.println("------------------------------");
		
		Optional<Double> op1 = emps.stream()
			.map(Employee::getSalary)
			.reduce(Double::sum);
		
		System.out.println(op1.get());
		
	}
	
	//需求：搜索名字中带有六出现的次数
	
	@Test
	public void test2() {
		
		Optional<Integer> op1 = emps.stream()
			.map(Employee::getName)
			.flatMap(TestStreamAPI1::filterCharacter)
			.map((ch) -> {
				if (ch.equals('六')) {
					return 1;
				}
				return 0;
			}).reduce(Integer::sum);
		
		System.out.println(op1.get());		
	}
	
	//collect--将六流转换成其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法、
	
	@Test
	public void test3() {
		
		List<String> list = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.toList());
		
		list.forEach(System.out::println);
		
		
		System.out.println("----------------------------");
		
		Set<String> set = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.toSet());
		
		set.forEach(System.out::println);
		
		System.out.println("-------------------------------");
		HashSet<String> haseSet = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.toCollection(HashSet::new));
		haseSet.forEach(System.out::println);
		
	}
	
	
	@Test
	public void test4() {
		
		Optional<Double> dou = emps.stream()
			.map(Employee::getSalary)
			.collect(Collectors.maxBy(Double::compare));
		
		System.out.println(dou.get());
		
		System.out.println("-------------------------");
		
		Optional<Double> op = emps.stream()
			.map(Employee::getSalary)
			.collect(Collectors.minBy(Double::compare));
		
		System.out.println(op.get());
		
		System.out.println("--------------------------");
		
		Double sum = emps.stream()
			.collect(Collectors.summingDouble(Employee::getSalary));
		
		System.out.println(sum);
		
		System.out.println("-------------------------");
		
		Double avg = emps.stream()
			.collect(Collectors.averagingDouble(Employee::getSalary));
		
		System.out.println(avg);
		
		Long count = emps.stream()
			.collect(Collectors.counting());
		
		System.out.println(count);
		
		System.out.println("--------------------------------");
		
		DoubleSummaryStatistics dss = emps.stream()
			.collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println(dss.getMin());
	}
	
	//分组
	@Test
	public void test5() {
		Map<Status, List<Employee>> map = emps.stream()
			.collect(Collectors.groupingBy(Employee::getStatus));
		
		System.out.println(map);		
	}
	
	
	//多级分组
	@Test
	public void test6() {
		
		Map<Status,Map<String, List<Employee>>> group = emps.stream()
			.collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
				if(e.getAge() >= 60)
					return "老年";
				else if(e.getAge() >= 35)
					return "中年";
				else
					return "成年";
			})));
		
		System.out.println(group);
		
	}
	
	//分区
	@Test
	public void test7() {
		Map<Boolean,List<Employee>> part = emps.stream()
			.collect(Collectors.partitioningBy(e -> e.getSalary() >= 5000));
		System.out.println(part);
	}
	
	//拼接
	@Test
	public void test8() {
		
		String str = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.joining(",","==","=="));
		System.out.println(str);
		
	}
	
	
	//收集求和
	@Test
	public void test9() {
		
		Optional<Double> dou = emps.stream()
			.map(Employee::getSalary)
			.collect(Collectors.reducing(Double::sum));
		System.out.println(dou.get());
	}
	
	
	
	
	
	
}
