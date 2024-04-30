package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point point = new Point();
		Class klass = point.getClass(); //refrection
		System.out.println(klass.toString());
		
		System.out.println(point.hashCode()); // address 기반의 해싱값
		
		System.out.println(point.toString()); // getClass() +"@"+ hashCode() 305623748 >> 123772c4 
		System.out.println(point); // println은 toString을 자동으로 불러 
	}

}
