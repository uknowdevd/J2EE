package com.sparc.singleton;

import com.sparc.prototype.MyPrototype;

public class Application {

	
	public static void main(String args[])
	{
		MySingleton sig = MySingleton.getInstance();
		sig.setName("Alice");
		
		System.out.println("Printing instance" + sig.getName());
		
		MySingleton sig2 = MySingleton.getInstance();
		
		sig2.setName("Wonderland");
		
		
		System.out.println("Printing instance" + sig2.getName());

		System.out.println("Printing instance of sig " + sig.getName());
		
		MySingleton sig3 = MySingleton.getInstance();

		System.out.println("Printing instance of sig 3" + sig3.getName());

		
		
		MyPrototype m1 = new MyPrototype();
		m1.setName("Dheeraj");
		
		MyPrototype m2 = new MyPrototype();
		
		m2.setName("Vamsi");

		MyPrototype m3 = new MyPrototype();
		
		m3.setName("Deepthi");
		
		System.out.println("Prototype instance " + m1.getName());

		System.out.println("Prototype instance " + m2.getName());

		System.out.println("Prototype instance " + m3.getName());

	}
}
