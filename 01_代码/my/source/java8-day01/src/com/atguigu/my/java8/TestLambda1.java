package com.atguigu.my.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;


/**
 * 
 * @author chenzhen-1
 * @date 2019年5月12日-下午2:35:14
 *
 **/
public class TestLambda1 {
	
	//匿名内部类
	@Test
	public void test01() {
		
		//定制比较器
		Comparator<String> com = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}			
		};
		TreeSet<String> ts = new TreeSet<>(com);
		
		//一般情况下使用定制比较器
		TreeSet<String> ts2 = new TreeSet<>(new Comparator<String>() {
			
			@Override
			public int compare(String o1,String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
			
		});
		
	}
	
	//现在的Lambda 表达式
	@Test
	public void test02() {
		
		//Lambda表达式1
		Comparator<String> com = (x, y) -> {return Integer.compare(x.length(), y.length());};
		
		//Lambda表达式2 : 只有一句Lambda 体时，可以省略大括号 和return 
		Comparator<String> com2 = (x, y) -> Integer.compare(x.length(), y.length());

	}
	
	//创建测试集合
	List<Employee> emps = Arrays.asList(
			new Employee(101, "张三", 18, 9999.99),
			new Employee(102, "李四", 59, 6666.66),
			new Employee(103, "王五", 28, 3333.33),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55)
			);
	
	//需求： 获取公司中年龄小于35的员工信息
	
	public List<Employee> filterEmployeeAge(List<Employee> emps){
		
		List<Employee> list = new ArrayList<>();
		
		for (Employee employee : emps) {
			if (employee.getAge() <= 35) {
				list.add(employee);
			}
		}
		return list;
	}
	
	@Test
	public void test3() {
		
		List<Employee> list = filterEmployeeAge(emps);
		
		for (Employee employee : list) {
			System.out.println(employee);			
		}
		
	}
	
	//需求： 获取公司中工资大于5000的员工信息
	public List<Employee> filterEmployeeSalary(List<Employee> emps){
		List<Employee> list = new ArrayList<>();
		
		for (Employee emp : emps) {
			if (emp.getSalary() >= 5000) {
				list.add(emp);
			}
		}
		return list;
	}
	//以上方法，当需求变动的时候，核心代码只需要修改一行，但是我们需要重写所有代码。造成大量多余的代码
	//优化方法一：策略设计模式
	public List<Employee> fileterEmployee(List<Employee> emps, MyPredicate<Employee> mp){
		
		List<Employee> list = new ArrayList<>();
		
		for (Employee emp : emps) {
			
			if (mp.test(emp)) {
				list.add(emp);
			}
			
		}
		return list;		
	}
	
	@Test
	public void test04() {
		
		List<Employee> list = fileterEmployee(emps, new FilterEmployeeForAge());
		
		for (Employee employee : list) {
			System.out.println(employee);		
		}
		System.out.println("----------------------------------------------");
		
		
		List<Employee> list2 = fileterEmployee(emps, new FileteEmployeeForSalary());
		
		for (Employee employee : list2) {
			System.out.println(employee);
		}
	}
	
	
	//优化方式二： 匿名内部类	
	@Test
	public void test5() {
		
		List<Employee> list = fileterEmployee(emps, new MyPredicate<Employee>() {

			@Override
			public boolean test(Employee emp) {
				return emp.getId() <= 103;
			}			
		});
		
		for (Employee emp : list) {
			System.out.println(emp);
		}	
		
	}
	
	//优化方式三： Lambda 表达式
	@Test
	public void test6() {
		List<Employee> list = fileterEmployee(emps, (e) -> e.getAge() <= 35);
		//遍历
		list.forEach(System.out::println);
		
		System.out.println("--------------------------------------");
		
		List<Employee> list2 = fileterEmployee(emps, (e) -> e.getSalary() >= 5000);
		list2.forEach(System.out::println);
		
	}
	
	//Stream API 优化
	@Test
	public void test7() {
		emps.stream()
			.filter((e) -> e.getAge() <= 35)
			.forEach(System.out::println);	
		
		System.out.println("--------------------------");
		
		emps.stream()
			.filter((e) -> e.getSalary() >= 5000)
			.limit(2)
//			.sorted()
			.forEach(System.out::println);
		
	}
	
	
	

}
