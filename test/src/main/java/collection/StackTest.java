package collection;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> s = new Stack();
		
		s.push("둘리");
		s.push("도우나");
		s.push("아기공룡");
		System.out.println(s.peek());
		while(!s.isEmpty()) {
			String str = s.pop();
			System.out.println(str);
		}
		
		// 비어있는 경우 예외 s.pop();
//		System.out.println(s.pop());

	}

}
