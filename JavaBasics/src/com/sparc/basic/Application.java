package com.sparc.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sparc.basic.entity.Person;

public class Application {

	public static void main(String[] args) {
	List<Person> perList = new ArrayList<Person>();
	Set<Person> perSet = new HashSet<Person>();
	
		
		Person p1 = new Person(1);
        p1.setFirstName("Dheeraj");
        p1.setLastName("Gundra");
        
        
        Person p2 = new Person(2);
        p2.setFirstName("Dheeraj");
        p2.setLastName("Modugula");

//        System.out.println(p1.getName());
//        System.out.println(p2.getName());
//        
//        System.out.println("Comparing both objects " + p1.equals(p2));
//
//        System.out.println("Printing p1 hashcode " + (p1));
//
//        System.out.println("Printing p2 hashcode " + (p2));
//        
        perList.add(p1);
        perList.add(p2);
//        System.out.println("Comparing both objects " + (p1 == p1));

        perSet.add(p1);
        perSet.add(p2);
        
        System.out.println("Printing the set " + perSet);

        System.out.println("Printing the List " + perList);

        

        

        
        
	}

}
