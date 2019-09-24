package com.atguigu.my.java8;

/**
 * 
 * @author chenzhen-1
 * @date 2019年5月12日-下午3:07:37
 *
 **/
public class FilterEmployeeForAge implements MyPredicate<Employee> {

	@Override
	public boolean test(Employee emp) {
		return emp.getAge() <= 35;
	}
	

}
