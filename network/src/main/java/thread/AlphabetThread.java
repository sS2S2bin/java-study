package thread;

public class AlphabetThread extends Thread {

	@Override
	public void run() {
		for(char c = 'a';c<'j';c++) {
			System.out.print(c);
		}
	}

}
