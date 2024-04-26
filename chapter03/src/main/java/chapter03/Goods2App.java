package chapter03;

import mypackage.Goods2;

public class Goods2App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goods2 goods = new Goods2();
		
		//public은 접근제한이 없다.
		goods.name = "camera";
		
		// protected는 같은 패키지 접근 가
		// 더 중요한 것은 자식에서 접근이 가능하다는 
		// goods.price = 2000;
		
		//디폴트 같은 패키지 접근 가능
		// goods.countStock=10;
		
		// private는 내부에서만 접근 가능
		// goods.countSold = 20;
	}

}
