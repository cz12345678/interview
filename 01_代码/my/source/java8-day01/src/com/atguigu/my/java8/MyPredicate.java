package com.atguigu.my.java8;

/**
 * 
 * @author chenzhen-1
 * @date 2019年5月12日-下午3:03:08
 *
 **/
@FunctionalInterface  //该注解代表该类是一个函数式接口
public interface MyPredicate<T> {

	boolean test(T t);
	
}
