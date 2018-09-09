package com.sparc.singleton;

public class MySingleton {

	private static final MySingleton instance = new MySingleton();
	
	private String name;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private MySingleton()
	{
		
	}
	
	public static MySingleton getInstance()
	{
		return instance;
	}
	
	
	
}
