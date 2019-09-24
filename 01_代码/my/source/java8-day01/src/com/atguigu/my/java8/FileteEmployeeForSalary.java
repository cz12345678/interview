package com.atguigu.my.java8;

/**
 * 
 * @author chenzhen-1
 * @date 2019年5月12日-下午3:15:46
 *
 **/
public class FileteEmployeeForSalary implements MyPredicate<Employee>{

	@Override
	public boolean test(Employee emp) {
		return emp.getSalary() >= 5000;
	}

}
