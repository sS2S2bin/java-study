package exception;

@SuppressWarnings("serial")
public class MyException extends Exception {
	public MyException(String message) {
		super(message); //custome message
	}
	
	public MyException() { //기본 메세ㅈㅣ
		super("MyException Thrown");
	}

}
