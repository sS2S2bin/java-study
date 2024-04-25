package prob02;

public class Goods {
	private String name;
	private int price; 
	private int stockCount;
	public Goods(String name, int price, int stockCount) {
		this.name = name;
		this.price = price;
		this.stockCount = stockCount;
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
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStockCount() {
		return stockCount;
	}
	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}
	
	public static void show(Goods goods) {
		System.out.println( goods.getName()+ 
				" (가격 : "+ goods.getPrice() + "원)이 "+
				goods.getStockCount()+"개 입고 되었습니다.");
	}
	
}
