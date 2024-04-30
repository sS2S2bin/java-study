package chapter04;

public class ObjectTest02 {

	public static void main(String[] args) {
		Point p1 = new Point(10,20);
		Point p2 = new Point(10,20);
		Point p3 = p2;
		
		// == : 동일성 비교 : 같은 객체?
		System.out.println(p1==p2); //false
		System.out.println(p2==p3); //true
		
		
		// equals : 동질성 비교 : 같은 내용?
		//			부모 클래스 Object의 기본 구현은 동일성(==) 비교와 같다.
		System.out.println(p1.equals(p2)); //false
		System.out.println(p2.equals(p3)); //true
		

	}

}
