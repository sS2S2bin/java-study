package chapter03;

public class StaticMethod {
	int n;
	static int m;
	
	void f1() {
		n = 10;
	}
	
	void f2() {
		StaticMethod.m = 10; //이게 원
		m = 20; // 같은 클래스의 클래스(static) 변수 접근에서는 클래스 이름 생략 가능
	}
	
	void f3() {
		f2();
	}
	
	void f4() {
		StaticMethod.s1();
		s1(); // 같은 클래스의 클래스(static) 변수 접근에서는 클래스 이름 생략 가능
	}
	static void s1() {
		// n = 10;
		// Error : static 메소드 에서는 instance 변수에 접근 불가하다.
	}
	static void s2() {
//		 f1();
		// Error : static 메소드 에서는 instance 메소에 접근 불가하다.
	}
	static void s3() {
		StaticMethod.m = 10;
		m = 10; // 같은 클래스 static 변수 접근에선 생략 가
	}
	static void s4() {
		StaticMethod.s1();
		s1();// 같은 클래스의 클래스(static)메소드 접근에서는 클래스 이름 생략 가
	}
}
