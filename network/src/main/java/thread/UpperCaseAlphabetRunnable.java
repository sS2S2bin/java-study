package thread;

public class UpperCaseAlphabetRunnable extends UpperCaseAlphabet implements Runnable {

	@Override
	public void run() {
		print(); // 상속받은 UpperCaseAlphabet 클래스의 메서드. 이런 방식으로 스레드에 태우기 
	}

}
