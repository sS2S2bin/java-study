package chapter03;

import mypackage.Goods2;

public class DiscountGoods2 extends Goods2 {
	private float discountRate = 0.5f; //그냥 0.5 적으면 double, 0.5f라고 적어야 float
	
	public float getDiscountPrice() {
		// protected는 자식에서 접근 가
		return discountRate * price;
	}
	
	

}
