package prob01;

public class Printer {
	// generic 쓰면 오버로드 할 필요 X
	/*
	public void println( int num ) {
		System.out.println(num);
	}
	public void println( boolean num ) {
		System.out.println(num);
	}
	public void println( double num ) {
		System.out.println(num); //float로 어떻게?
	}
	public void println( String num ) {
		System.out.println(num);
	}
	*/
	public <T> void println(T t) { //return type:T return t; 가능 // T t 입력 x 가능?
		System.out.println(t);
	}
	public <T> void println(T... ts) { //return type:T return t; 가능 // T t 입력 x 가능?
		for(T t: ts) {
			System.out.print(t);
		}
	}
	/*
	 *  int i = pritnlnt("hello",3);
	 * 	public <T,S> void println(T t, S s) { //return type:T return t; 가능 // T t 입력 x 가능?
		System.out.println(t);
		return s;
	} 
	 * */
	
	public int sum(Integer... nums) {
		int s = 0;
		for (Integer n : nums) {
			s += n;
		}
		return s;
	}

}
