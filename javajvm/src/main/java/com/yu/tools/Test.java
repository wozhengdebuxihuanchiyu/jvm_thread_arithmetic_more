package com.yu.tools;

import java.util.Calendar;

public  class Test {

	public static void main(String[] args) {
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.DATE,-1);
		System.out.println(instance.getTime());
		
		System.out.println(System.getenv("JAVA_HOME"));
		
		System.out.println(System.getProperties());
		
		System.out.println(Runtime.getRuntime().totalMemory());
		System.out.println(Runtime.getRuntime().freeMemory());
		
		
		String str = "11";
		int  i = Integer.parseInt(str);
		System.out.println(i);
		
	}
	
}
