package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for(int i=0; i<COUNT_GOODS; i++) {
			String line = scanner.nextLine();
			String[] data = line.split(" ");
			String name = data[0];
			int price = Integer.parseInt(data[1]);
			int stockCount = Integer.parseInt(data[2]);
			goods[i] = new Goods(name, price, stockCount);
			
		}
		
		// 상품 출
		for(int i=0; i<COUNT_GOODS; i++) {
			Goods.show(goods[i]);
		}
		
		
		// 자원정리
		scanner.close();
	}
}
