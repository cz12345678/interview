package com.thunisoft.test;

public class Person 
{
	
	public static void main(String[] args) {
		System.err.println(2 << 3);
	}
	private Integer id;
	private String  personName;
	
	public Person() {}

	public Person(String personName)
	{
		super();
		this.personName = personName;
	}

	public Person(Integer id, String personName)
	{
		super();
		this.id = id;
		this.personName = personName;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getPersonName()
	{
		return personName;
	}

	public void setPersonName(String personName)
	{
		this.personName = personName;
	}

}
