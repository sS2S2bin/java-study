package paint;

public class ColorPoint extends Point {
	private String color;
	public ColorPoint(int x, int y, String color) {
		// setX(x);
		// setY(y);
		super(x,y);
		this.color = color;
	}
	
	
	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	// @어노테이션
	@Override 
	public void show() {
		//super.show(); 
		
		//완전 재구현
		System.out.println("점 (" + getX() + getY() + color+" ) 을 그렸습니다.");
	}
	
}
