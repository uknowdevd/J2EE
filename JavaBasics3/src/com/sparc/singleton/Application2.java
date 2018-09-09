package com.sparc.singleton;

import com.sparc.enumtype.Day;
import com.sparc.enumtype.EnumPrint;

public class Application2 {
	
	
	public static void main (String[] args)
	{
		EnumPrint  monday = new EnumPrint(Day.MONDAY);
		
		EnumPrint friday = new EnumPrint(Day.FRIDAY);
		
		
		System.out.println("Monday " + monday.whatYouThinkOfDay())
		;
		
		System.out.println("Monday " + friday.whatYouThinkOfDay())
		;
	}

}
