package com.thunisoft.test.concurrent.sigleton;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 在内部类被加载和初始化时，才创建INSTANCE实例对象
 * 静态内部类不会自动随着外部类的加载和初始化而初始化，它是要单独去加载和初始化的。
 * 因为是在内部类加载和初始化时，创建的，因此是线程安全的
 */
public class Singleton6 {
	private Singleton6(){
		System.out.println("outer");
	}

	private static class Inner{
		private static final Singleton6 INSTANCE = new Singleton6();
	}
	
	public static Singleton6 getInstance(){
		return Inner.INSTANCE;
	}


	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 100; i++) {
			executorService.submit(() -> {
				System.out.println(getInstance());
			});
		}

		executorService.shutdown();

//		String a = "aaaa";
//
//
//		String b = a.replace("a","b");
//
//		System.out.println(a);
//		System.out.println(b);

//		LocalDateTime now = LocalDateTime.now();
//
//		now.with(TemporalAdjusters.lastDayOfYear());
//
//		System.out.println(now);

	}
}
