package com.sparc.singleton;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Application3 {

	public static void main(String args[]) {

		String inputStr = "00:01:07,400-234-090\n" + "00:05:01,701-080-080\n" + "00:05:00,400-234-090";

		String[] strArr = inputStr.split("\\n");
		Map<String, Long> phoneMap = new HashMap<String, Long>();

		//iterates 3 times
		for (String str : strArr) {
			//System.out.println(str);

			
			//Create array of length 2
			String[] eachLine = str.split(",");

			
			DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			Date reference;
			try {
				reference = dateFormat.parse("00:00:00");
				Date date = dateFormat.parse(eachLine[0]);
				long seconds = (date.getTime() - reference.getTime()) / 1000L;
				//System.out.println("Printing seconds" + seconds);
				if(!phoneMap.containsKey(eachLine[1]))
				{
				phoneMap.put(eachLine[1], seconds);
				}
				else
				{
					phoneMap.put(eachLine[1], phoneMap.get(eachLine[1]) + seconds);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
		System.out.println("Printing seconds for each phone" + phoneMap);

	}

}
