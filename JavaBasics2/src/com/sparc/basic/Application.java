package com.sparc.basic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.sparc.entity.Person;

public class Application {
	

	/**
	 * For loop example with collections
	 * @param args
	 */
	public static void main (String[] args)
	{
		List<Person> personList = new ArrayList<Person>();
		Set<Person> personSet  = new HashSet<Person>();
		 TreeSet<Person> personTreeSet = new TreeSet<Person>(new SortByFirstName());

		
		Person p1  = new Person(1);
		p1.setFirstName("Vamsi");
		p1.setLastName("Krishna");
		
		Person p2 = new Person(2);
		p2.setFirstName("Deepthi");
		p2.setLastName("Choudhary");
		
	    Person p3 = new Person(3);
	    p3.setFirstName("Rajendra");
	    p3.setLastName("Modugula");
	    
	    personList.add(p1);
	    personList.add(p2);
	    personList.add(p3);
	    personList.add(null);
	    for(Person p : personList)
	    {
	    	System.out.println("Printing each person  in List" + p);
	    	
	    }
	    
	    
	    
	    personSet.add(p1);
	    personSet.add(null);
	    personSet.add(p2);
	    personSet.add(p3);
	    
	    for(Person p : personSet)
	    {
	    	System.out.println("Printing each person in Set" + p);
	    	
	    }
	    
	    
	    personTreeSet.add(p1);
	    personTreeSet.add(p2);
	    personTreeSet.add(p3);

	    
	    for(Person p : personTreeSet)
	    {
	    	System.out.println("Printing each person in TreeSet" + p);
	    	
	    }
	    
	    
	    
	}

	
	
	
}
