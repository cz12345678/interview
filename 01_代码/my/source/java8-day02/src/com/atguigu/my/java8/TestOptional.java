package com.atguigu.my.java8;

import java.util.Optional;

import org.junit.Test;

import com.atguigu.java8.Employee;

/**
 * 
 * @author chenzhen-1
 * @date 2019年5月13日-下午4:57:48
 * 	一、 Optional 容器类：用于尽量避免空指针异常
 * 		Optional.of(T t)： 创建一个Optional的实例
 * 		Optional.empty(): 创建一个空的Optional 实例
 * 		Optioanl.ofNullable(T t): 若t 不为null ，创建Optional 实例，否则创建空实例
 * 		isPresent(): 判断是否包含值
 * 		orElse(T t): 如果调用对象包含值，返回该值，否则返回t
 * 		orElseGet(Supplier s): 如果调用对象包含值，返回该值。否则返回s 获取的值
 *		map(Function f) : 如果有值对齐进行处理，并返回处理候的Optional， 否则返回Optional.empty()	
 *		flatMap(Function mapper):与map 类似，要求返回值必须是Optional
 *
 **/
public class TestOptional {
	
	@Test
	public void test01() {
		Optional<Employee> op1 = Optional.of(new Employee());
		Employee emp = op1.get();
		System.out.println(emp);
	}
	
	@Test
	public void test02() {
		
		Optional<Employee> op1 = Optional.ofNullable(new Employee());
		if (op1.isPresent()) {
			System.out.println(op1.get());
		}
		
		Employee emp = op1.orElse(new Employee("zhangsan"));
		System.out.println(emp);
		
		Employee emp2 = op1.orElseGet(Employee::new);
		System.out.println(emp2);
		
	}
	
	
	
	
	
	
	

}
