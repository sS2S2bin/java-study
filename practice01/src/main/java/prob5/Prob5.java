package prob5;

import java.util.Arrays;
import java.awt.List;
import java.util.ArrayList;

public class Prob5 {

	public static void main(String[] args) {
		for (int i=1;i<100; i++) {
			String s = String.valueOf(i);
//			boolean clap = false;
//		
//			for (int j=0;j<s.length();j++) {
//				char c = s.charAt(j);
//				if (c=='3'|| c=='6' || c=='9') {
//					clap = true;
//				}
//			}
//			if (clap) {
//				System.out.println(i+" 짝");
//				clap=false;
//			}
			String[] arr = s.split("");
			ArrayList<String> strarr = new ArrayList<String>(Arrays.asList(arr));
			if(strarr.contains("3")||strarr.contains("6")||strarr.contains("9")) {
				System.out.println(i+" 짝");
			}

		}
	}
}
