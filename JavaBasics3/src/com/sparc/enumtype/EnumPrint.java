package com.sparc.enumtype;

public class EnumPrint {
	
	Day day;
	
	public EnumPrint(Day day)
	{
		this.day = day;
	}
	
	public String whatYouThinkOfDay()
	{
		switch(day)
		{
		case SUNDAY:
			return "Enjoyment but Monday is next";
			
		case SATUARDAY:
			return "Enjoyment ";
		
			
		case FRIDAY:
			return  "Weekend is next - fun";
			
			
		default:
			return "No comment of mid days";
		}
	}

}
