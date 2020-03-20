package com.thunisoft.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.rules.Stopwatch;

/**
 * @describe: 
 * @author:  chenzhen-1
 * @date: 2019-3-12-下午2:07:36
 */
public class CollectionTest {
	
	
	public static void main(String[] args) throws Exception {

		List<String> strList = new ArrayList<String>();
		strList.add("xx");
		strList.add("x");
		strList.add("yy");
		strList.add("zz");		
		System.out.println(strList);
		
		List<String> list = new ArrayList<String>();
		list.add("yy");

		System.out.println(Collections.indexOfSubList(strList, list));
		
	}

}

class H{
	
	private String name;
	
	private Integer age;
	

	public H(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		H other = (H) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	
	
}
