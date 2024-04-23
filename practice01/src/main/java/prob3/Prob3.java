package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요: ");
		int num = scanner.nextInt();
		int answer = 0;
		while(num>0) {
			answer += num;
			num -= 2;
		}
		System.out.print("결과 값:"+answer);
		scanner.close();
	}
}
