package mypackage;
import java.util.*;              
public class Test {
	public static void main(String[] args) {
		int a = 10;
		System.out.println(a);
		String s = String.valueOf(a);
		System.out.println(s);
		stoa(s);
		System.out.println("change?"+s);
		s = "30";
		System.out.println(s.toString());
		a = Integer.parseInt(s);
		System.out.println(a);
		
		
	}
	public static void stoa(String ss) {
		ss = "500";
		int aa = Integer.parseInt(ss);
		ss = String.valueOf(ss);
		System.out.println("inside?"+ss);
		
	}
}
