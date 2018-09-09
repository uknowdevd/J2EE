package com.sparc.basic;

import java.util.Comparator;

import com.sparc.entity.Person;

public class SortByFirstName implements Comparator<Person>{

	
	 
			@Override
			public int compare(Person o1, Person o2) {
				
				return o1.getFirstName().compareTo(o2.getFirstName());
			}
			
		
}
