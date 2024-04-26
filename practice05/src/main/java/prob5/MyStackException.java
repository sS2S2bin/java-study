package prob5;

@SuppressWarnings("serial")
public class MyStackException extends Exception {
	
	public MyStackException(String message) {
		super(message); //custome message
	}
	
	public MyStackException() { //기본 메세ㅈㅣ
		super("stack is empty");
	}

}
