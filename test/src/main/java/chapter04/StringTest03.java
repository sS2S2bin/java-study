package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		String s1 = "hello" + "world" + "java" + 17;
		/* 내부적으로 이렇게 되는 거야
		String s1 = new StringBuffer("hello").append("world")
		.append("java").append(17).toString();
		*/
		System.out.println(s1);
		


	}

}
