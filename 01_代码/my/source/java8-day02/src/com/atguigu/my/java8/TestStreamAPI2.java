package com.atguigu.my.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

import com.atguigu.java8.Employee;
import com.atguigu.java8.Employee.Status;

/**
 * 
 * @author chenzhen-1
 * @date 2019年5月13日-下午2:50:22
 *
 *	一、 Stream 的操作步骤
 *		
 *	1.创建 Stream
 *
 *	2. 中间操作
 *	
 *	3.终止操作
 *
 **/
public class TestStreamAPI2 {
	
	List<Employee> emps = Arrays.asList(new Employee(102, "李四", 59, 6666.66, Status.BUSY),
			new Employee(101, "张三", 18, 9999.99, Status.FREE),
			new Employee(103, "王五", 28, 3333.33, Status.VOCATION),
			new Employee(104, "赵六", 8, 7777.77, Status.BUSY),
			new Employee(104, "赵六", 8, 7777.77, Status.FREE),
			new Employee(104, "赵六", 8, 7777.77, Status.FREE),
			new Employee(105, "田七", 38, 5555.55, Status.BUSY)
	);
	
	//终止操作
	/**
	 *	allMatch()--检查是否匹配所有元素
	 *	anyMatch() --检查是否至少匹配一个元素
	 *	noneMatch() --检查是否没有匹配的元素
	 *	findFirst() --返回第一个元素
	 *	findAny() --返回当前流中的任意元素
	 *	count() --返回流中元素的总个数
	 *	max --返回流中最大值
	 *	min --返回流中最小值
	 * 
	 */
	
	@Test
	public void test1() {
		boolean busy = emps.stream()
			.allMatch(e -> e.getStatus().equals(Status.BUSY));
		System.out.println(busy);
		
		System.out.println("-------------------");
		
		boolean any = emps.stream()
			.anyMatch(e -> e.getStatus().equals(Status.BUSY));
		System.out.println(any);
		
		System.out.println("-------------------");
		
		boolean none = emps.stream()
			.noneMatch(e -> e.getStatus().equals(Status.BUSY));
		System.out.println(none);	
		
	}
	
	
	@Test
	public void test2() {
		
		Optional<Employee> op = emps.stream()
			.sorted((x, y) -> Integer.compare(x.getAge(), y.getAge()))
			.findFirst();
		
		System.out.println(op.get());
		System.out.println("---------------------");
		Optional<Employee> op1 = emps.parallelStream()
			.filter(e -> e.getStatus().equals(Status.BUSY))
			.findAny();
		System.out.println(op1.get());
		
	}
	
	
	@Test
	public void test3() {
		
		long count = emps.stream()
			.filter(e -> e.getStatus().equals(Status.FREE))
			.count();
		System.out.println(count);
		
		System.out.println("------------------------------");
		
		Optional<Double> max = emps.stream()
			.map(Employee::getSalary)
			.max(Double::compare);
		System.out.println(max.get());
		
		System.out.println("-----------------");
		
		Optional<Employee> emp = emps.stream()
			.max((x, y) -> Double.compare(x.getSalary(), y.getSalary()));
		System.out.println(emp.get());
	}
	
	
	//注意：流进行了终止操作后，不能再次使用
	@Test
	public void test4() {
		
		Stream<Employee> stream = emps.stream()
			.filter(e -> e.getStatus().equals(Status.BUSY));
			
		long count = stream.count();
		
		
		//再次执行下面语句，报错
		Stream<Double> sd = stream.map(Employee::getSalary);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
