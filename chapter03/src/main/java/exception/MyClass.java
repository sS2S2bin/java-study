package exception;

import java.io.IOException;

public class MyClass {
	public void danger() throws IOException,MyException { //던질 가능성이 있다는걸 알려줘야해
		System.out.println("Some code1");
		System.out.println("Some code2");
		
		if(2-2==0) {
			throw new MyException(); //커스텀 메세지 던지고 싶을 때
		}
		if(1-1==0) {
			throw new IOException();
		}
		
		System.out.println("Some code3");
		System.out.println("Some code4");
		
	}
}
