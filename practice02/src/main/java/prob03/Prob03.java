package prob03;
import java.util.Arrays;

public class Prob03 {
	public static void main(String args[]) {
		char c[] = { 'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l', '.' };

		// 원래 배열 원소 출력
		printCharArray(c);

		// 공백 문자 바꾸기
		replaceSpace(c);

		// 수정된 배열 원소 출력
		printCharArray(c);
	}

	public static void replaceSpace(char[] arr) {
		// TODO Auto-generated method stub
		/* 이렇게 되면 s의 새로운 charArray 객체를 arr가 가르키고 사라지기 때문에 바뀌지 않
		String s = String.valueOf(arr);
		s = s.replaceAll(" ",",");
		System.out.println(s);
		arr = s.toCharArray();
		System.out.println(Arrays.toString(arr));
		*/
		for(int i =0; i<arr.length; i++) {
			if(arr[i]==' ') {
				arr[i]=',';
			}
		}
		
		
	}

	public static void printCharArray(char[] c) {
		// TODO Auto-generated method stub
		System.out.println(c);
		
	}
	

}
