package prob01;

public class PrinterTest {

	public static void main(String[] args) {
		Printer printer = new Printer();

		printer.<Integer>println( 10 ); // 이거 생략 가능
		printer.println( true );
		printer.println( 5.7 );
		printer.println( "홍길동" );
		printer.println(100,true,"가변파라미터랑 제너릭 혼합");
		
		/*
		printer.println( 10 );
		printer.println( true );
		printer.println( 5.7 );
		printer.println( "홍길동" );
		 */
		System.out.println(printer.sum(1,2,3,4,5,6));
	}
}