package prob05;

public class Prob05 {

	public static void main(String[] args) {
		Base base = new MyBase(); //base 상속 받아서 myBase만 만들어서 출력이 나오게

		base.service("낮");
		base.service("밤");
		base.service("오후"); 
	}
}
