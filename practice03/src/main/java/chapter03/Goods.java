package chapter03;

public class Goods {
	public static int countOfGoods = 0;
	
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	//기본 생성자 오버로드
	public Goods() {
		// 지금 이 상태면 count가 안생겨 >> 중복코드는 정말 안좋은 것임
		this("",0,0,0);
	}
	
	//내가 기본 생성자 만들기
	public Goods(String name, int price, int countStock, int countSold) {
		Goods.countOfGoods++; //class이름으로 접근해야해. // 클래스 이름 생략 가능 내부에서 쓸 때는 안적어도 뭐라하진 않아.
		
		// 인스턴스 변수 초기화
		this.name = name;
		this.price = price;
		this.countStock = countStock;
		this.countSold = countSold;
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	
	//정보은닉(데이터보호)
	public void setPrice(int price) {
		if(price<0) {
			price = 0;
			System.out.println("음수 값은 입력될 수 없습니다.");
		}
		this.price = price;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	
	public void showInfo() {
		System.out.println("상품 이름 : "+name+ " 가격:"+price+ " 재고개수 : "+countStock+ " 팔린 개수: "+countSold);
	}
	
	public int calcDiscountPrice(float percentage){
		int result =  (int)(price*(1-percentage));
		
		return result;
	}
	
}
