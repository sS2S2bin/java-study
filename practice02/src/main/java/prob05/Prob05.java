package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );

		int cnt = 1;
		while( true ) {
			
			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt( 100 ) + 1;
			System.out.println(correctNumber);
			System.out.println("수를 결정하였습니다. 맞추어보세요. ");
			System.out.println("1-100");
			int minAnswer = 1;
			int maxAnswer = 100;
			while(true) {	
				int inputAnswer = scanner.nextInt();
				System.out.println(cnt+">>"+inputAnswer);
				/* 게임 작성 */
				if(correctNumber == inputAnswer) { 
					System.out.println("맞았습니다! ");
					break;
				}
				else if(correctNumber<inputAnswer) {
					System.out.println("더 낮게 ");
					maxAnswer = inputAnswer;
					System.out.println(minAnswer+"-"+maxAnswer);
				}
				else if (correctNumber>inputAnswer) {
					minAnswer = inputAnswer;
					System.out.println("더 높게 ");
					System.out.println(minAnswer+"-"+maxAnswer);
				}
			}
			//새 게임 여부 확인하기
			System.out.print( "다시 하겠습니까(y/n)>>" );
			String answer = scanner.next();
			if( "y".equals( answer ) == false ) {
				break;
			}
			
			
		}
		
		scanner.close();
	}

}