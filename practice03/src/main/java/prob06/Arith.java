package prob06;

public abstract class Arith {
	protected int a,b; //자식>부모 클래스, 같은 패키지끼리 만 공
	public abstract int calculate();
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}

}
