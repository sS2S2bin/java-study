package chapter04;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		System.out.println(cal);
		
		printDate(cal);
//		Calendar.getInstance();
//		Locale aLocale = Locale.getDefault(Locale.Category.FORMAT);
//		System.out.println(aLocale);
		
//		TimeZone tz = TimeZone.getDefault();
//		System.out.println(tz);
		cal.set(Calendar.YEAR, 2024);
		cal.set(Calendar.MONTH, 11); //12월
		cal.set(Calendar.DATE, 25);
		printDate(cal);
		
		cal.set(2000, 3,25);
		cal.add(Calendar.DATE, 10000);
		printDate(cal);
		
	}
	
	private static void printDate(Calendar cal) {
		final String[] DAYS = {"일", "월", "화","수","목","금","토"};
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH); //0~11, +1
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK); //1(일)~7(토) 
		int hours = cal.get(Calendar.HOUR);
		int minutes = cal.get(Calendar.MINUTE);
		int seconds = cal.get(Calendar.SECOND);
		System.out.println(day);
		System.out.println(
				year+"/"+(month+1)+"/"+date+" "+
		hours +":"+minutes+":"+seconds);
	}

}
