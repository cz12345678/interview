package com.thunisoft.test.concurrent.sigleton;

import java.io.IOException;
import java.util.Properties;

/**
 * 	静态代码块饿汉式（适合复杂实例化）
 */
public class Singleton3 {
	public static final Singleton3 INSTANCE;
	private String info;
	
	static{
		try {
			Properties pro = new Properties();
			
			pro.load(Singleton3.class.getClassLoader().getResourceAsStream("single.properties"));
			
			INSTANCE = new Singleton3(pro.getProperty("info"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Singleton3(String info){
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Singleton3 [info=" + info + "]";
	}


	public static void main(String[] args) {
		Singleton3 instance = Singleton3.INSTANCE ;

		System.out.println(instance.getInfo());

	}
	
}
