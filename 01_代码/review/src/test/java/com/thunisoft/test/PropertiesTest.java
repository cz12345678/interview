package com.thunisoft.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @describe: 
 * @author:  chenzhen-1
 * @date: 2019-3-12-下午8:31:43
 */
public class PropertiesTest {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties props = new Properties();
		props.load(new FileInputStream("test.properties"));
		
		String name = (String)props.get("name");
		System.err.println(name);		
	}

}
