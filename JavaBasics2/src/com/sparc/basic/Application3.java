package com.sparc.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.sparc.entity.Person;

public class Application3 {

	
	/**
	 * Deserialization example
	 */
	public static void main (String[] args)
	{
		FileInputStream file  = null;
		ObjectInputStream in = null;
		String fileNm = "person.obj";
		
		try
		{
		 file = new FileInputStream(fileNm);
		in = new ObjectInputStream(file);
		Person p = (Person) in.readObject();
		
		in.close();
		file.close();
		
		System.out.println("Printing deserialized object" + p);
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
	}
}
