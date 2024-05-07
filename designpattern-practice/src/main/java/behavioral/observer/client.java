package behavioral.observer;

import java.util.Scanner;

public class client {

	public static void main(String[] args) {
		Subject<Integer> intSubject = new Subject<>();
		
		intSubject.registerObserver(new Observer<Integer>() {
			@Override
			public void update(Integer val) {
				System.out.println("Observer 01 : "+val);
			}
		});
		
		//화살표 함수 y = f(x) 
		intSubject.registerObserver( (Integer val) -> {
			System.out.println("Observer 02 : "+val);
		});
		
		//위랑 같음 자바는 함수가 객체지향은 절대안돼 그치만 지원해주는거야 이렇게 쓸 수 있도록 
		//intSubject.registerObserver(val -> System.out.println("Observer 01 : "+val));
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print(">> ");
			int val = scanner.nextInt();
			intSubject.changeSubject(val);
		}

	}

}
