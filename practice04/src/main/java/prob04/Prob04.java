package prob04;

// overrid 문제 depart 상속

public class Prob04 {

	public static void main(String[] args) {
		Employee pt = new Depart( "홍길동", 3000, "개발부" );
		pt.getInformation();
	}
}