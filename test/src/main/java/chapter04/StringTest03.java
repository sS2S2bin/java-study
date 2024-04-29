package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		String s1 = "hello" + "world" + "java" + 17;
		/* 내부적으로 이렇게 되는 거야
		String s1 = new StringBuffer("hello").append("world")
		.append("java").append(17).toString();
		*/
		System.out.println(s1);
		String s2 = new StringBuilder("hello ").append("world ")
				.append("java ").append(17).toString();
		
		
		StringBuffer sb = new StringBuffer("");
//		String s3 = "";
		for(int i=0;i<1000000;i++) {
			sb.append(i); // 이건 new가 아니라 메소드 실행이라 금방 끝나
//			s3 = s3+i;
//			s3 = new StringBuffer(s3).append(i).toString();	
		}
		
		String s4 = sb.toString();
		

		// String method들
		String s5 = "aBcABCabc";
		System.out.println(s5.length());
		System.out.println(s5.charAt(2));
		System.out.println(s5.indexOf("ABC"));
		System.out.println(s5.indexOf("B",3));
		System.out.println(s5.substring(3,5));
		
		String s6 = "  sa b    ";
		String s7 = "efg,hij,klm,nop,qrs";
		String s8 = s6.concat(s7);
		System.out.println(s8);
		
		System.out.println("=="+s6.trim()+"--");
		System.out.println("=="+s6.replaceAll(" ","")+"--");
		
		String[] tokens = s7.split(",");
		for(String s : tokens) {
			System.out.println(s);
		}
		System.out.println("------------");
		String[] tokens2 = s7.split(" ");
		for (String s: tokens2) {
			System.out.println(s);
			System.out.println("?");
		}
	}

}
