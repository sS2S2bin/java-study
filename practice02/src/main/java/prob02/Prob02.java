package prob02;

import java.util.Scanner;
import java.util.Arrays;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[ 5 ];
		double sum = 0;

		/* 키보드에서 배열 크기만큼 입력 받아 배열에 저장하는 코드 */
		System.out.print("5개의 숫자를 입력하세요. ");
		for(int i = 0; i<5; i++) {
			int num = scanner.nextInt();
			intArray[i] = num;
			/* 배열에 저장된 정수 값 더하기 */
			sum += num;
		}
		System.out.println(Arrays.toString(intArray));
		
		sum /= 5;
		/* 출력 */
		System.out.print("평균은 "+sum+" 입니다. ");
		
		/* 자원정리 */
		scanner.close();
	}
}
