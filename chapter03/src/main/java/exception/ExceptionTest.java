package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10-a;

		System.out.println("Some code1");
		//예외 발생 전 , 발생할 것 같은 코드에
		try {
			System.out.println("Some code2");
			int result = (1+2+3)/b;
			System.out.println("Some code3");
		}catch(ArithmeticException ex) {
			// 1. 파일 로깅(sfj)
			System.out.println("error: "+ex);
			// 2. 사과 
			System.out.println("ㅈㅅ합니다요ㅠ");
			// 3. 정상종료
			System.exit(0);
		} finally {
			System.out.println("자원 정리 ex) close file, socket, db connection");
		}
		System.out.println("try catch end!");
	}

}
