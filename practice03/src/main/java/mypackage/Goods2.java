package mypackage;

public class Goods2 {
	public String name; //모든 접근 가능(접근제한 없다)
	protected int price; //같은 패키지 + 자식클래스 접
	int countStock; // 같은 패키지(default) 
	private int countSold; // 클래스 내부에서만 접근 가능 
	
	// 클래스 내부에서만 가능
	public void m() {
		countSold = 50;
	}
	
}
