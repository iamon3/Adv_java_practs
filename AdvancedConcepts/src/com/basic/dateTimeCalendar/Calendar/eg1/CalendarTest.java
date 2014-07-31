package com.basic.dateTimeCalendar.Calendar.eg1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");	
		Calendar calendar = new GregorianCalendar(2013,1,28,13,24,56);
		System.out.println(sdf.format(calendar.getTime()));
		
		int year       = calendar.get(Calendar.YEAR);
		int month      = calendar.get(Calendar.MONTH); // Jan = 0, dec = 11
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); 
		int dayOfWeek  = calendar.get(Calendar.DAY_OF_WEEK);
		int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
		int weekOfMonth= calendar.get(Calendar.WEEK_OF_MONTH);
	 
		int hour       = calendar.get(Calendar.HOUR);        // 12 hour clock
		int hourOfDay  = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock
		int minute     = calendar.get(Calendar.MINUTE);
		int second     = calendar.get(Calendar.SECOND);
		int millisecond= calendar.get(Calendar.MILLISECOND);
	 
		System.out.println(sdf.format(calendar.getTime()));
	 
		System.out.println("year \t\t: " + year);
		System.out.println("month \t\t: " + month);
		System.out.println("dayOfMonth \t: " + dayOfMonth);
		System.out.println("dayOfWeek \t: " + dayOfWeek);
		System.out.println("weekOfYear \t: " + weekOfYear);
		System.out.println("weekOfMonth \t: " + weekOfMonth);
	 
		System.out.println("hour \t\t: " + hour);
		System.out.println("hourOfDay \t: " + hourOfDay);
		System.out.println("minute \t\t: " + minute);
		System.out.println("second \t\t: " + second);
		System.out.println("millisecond \t: " + millisecond);
		
		
		// 2. Update a date
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONTH, 11);
		calendar.set(Calendar.MINUTE, 33);
		
		System.out.println("\n#2. After Updating " + sdf.format(calendar.getTime()));
		
		
		// 3. Add or subtract from a date.
		calendar = new GregorianCalendar(2013,10,28);	
		System.out.println("\n## Before adding subtracting, Date : " + sdf.format(calendar.getTime()));
	 
		//add one month
		calendar.add(Calendar.MONTH, 1);
		System.out.println("\n#3 After adding month, Date : " + sdf.format(calendar.getTime()));
	 
		//subtract 10 days
		calendar.add(Calendar.DAY_OF_MONTH, -10);
		System.out.println("\n#4 After subtracting 10 days, Date : " + sdf.format(calendar.getTime()));
	}
}
