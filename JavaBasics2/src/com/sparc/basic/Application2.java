package com.sparc.basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.sparc.entity.Person;

public class Application2 {
	
	/*
	 * Example of Serialization
	 * 
	 */
	public static void main (String[] args)
	{
		FileOutputStream file  = null;
		ObjectOutputStream out = null;
		Person p1 = new Person(1);
		String fileNm = "person.obj";
		
		p1.setFirstName("Raju");
		p1.setLastName("Srivastav");
		try
		{
		 file = new FileOutputStream(fileNm);
		out = new ObjectOutputStream(file);
		out.writeObject(p1);
		
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Entering finally block");
			try {
				out.close();
				file.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
