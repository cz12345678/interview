package com.atguigu.my.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

/**
 * 一、Lambda 表达式的基础语法： Java8 中引入了一个新的操作符 “->” 该操作符被称为
 * 		箭头操作符或 Lambda 操作符
 * 
 * 左侧： Lambda 表达式的参数列表
 * 右侧： Lambda 表达式中所需要执行的功能，即lambda体
 * 
 * 语法格式一： 无参数，无返回值
 * 		() -> System.out.println("Hello world");
 * 
 * 语法格式二： 有一个参数，并且无返回值
 * 		(x) -> System.out.println(x);
 * 
 * 语法格式三： 若只有一个参数，小括号可以省略不写
 * 		x -> System.out.println(x);
 * 
 * 语法格式四：有两个以上的参数，有返回值，并且Lambda 体中有多条语句
 * 		Comparator<Integer> com = (x, y) -> {
 * 			System.out.println("函数式接口");
 * 			return Integer.compare(x, y);
 * 		}
 * 
 * 语法格式五：若Lambda 体重只有一条语句，return 和 大括号都可以省略不写
 * 		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
 * 
 * 语法格式六：Lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型
 * 	即 “类型推断”
 * 		(Integer x, Integer y) -> Integer.compare(x, y);
 * 
 * 上联： 左右遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 * 
 * 二、 Lambda 表达式需要“函数式接口的支持”
 * 	函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。可以使用注解@FunctionInterface修饰
 * 		可以检查是否是函数式接口
 *
 *
 **/
public class TestLambda2 {
	
	@Test
	public void test01() {
		
		int num = 0; //jdk 1.7之前，必须是final修饰（当使用在新的线程中）
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				System.out.println(num);
			}
		};
		
		r.run();
		
		System.out.println("-----------------");
		//Lambda 表达式
		
		Runnable r1 = () -> System.out.println("Hello Lambda !");
		r1.run();
		
	}
	
	
	@Test
	public void test2() {
		
		Consumer<String> con = x -> System.out.println(x);
		con.accept("瑟瑟发抖！");
	}
	
	
	@Test
	public void test3() {		
		Comparator<Integer> com = (x,y) -> {
			System.out.println("函数式接口");
			return Integer.compare(x, y);			
		};		
		System.out.println(com.compare(11, 16));		
	}
	
	
	@Test
	public void test4() {		
		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);		
	}
	
	@Test
	public void test5() {
		
		List<String> list = new ArrayList<>();
		
		show(new HashMap<>());//类型推断
		
	}
	
	public void show(Map<String,Object> map) {
	}
	
	
	@Test
	public void test6() {
		
		Integer num = operation(100, (x) -> x*x);
		System.out.println(num);
		
		Integer sum = operation(100, x -> Integer.sum(x, x));
		
		System.out.println(sum);
		
	}
	
	public Integer operation(Integer num, MyFun<Integer> mf) {
		return mf.getValue(num);
	}

}
