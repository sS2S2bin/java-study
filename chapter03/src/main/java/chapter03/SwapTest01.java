package chapter03;

public class SwapTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 10;
		int j = 20;
		
		System.out.println(i+" , "+j);
		/* i랑 j값을 바꿔 */
		int tmp = j;
		j  = i;
		i = tmp;
		System.out.println(i+" , "+j);
		

	}

}
