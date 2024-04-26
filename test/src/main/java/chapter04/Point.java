package chapter04;

import java.util.Objects;

public class Point {
	private int x;
	private int y;
	

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	} 
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(x, y); 
		// 내용 기반 hash
		// 원래는 주소 기반이라서 hash 코드가 같음
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}
	
	public Point() {
	}
	
	public Point( int x, int y ) {
		this.x = x;
		this.y = y;  
		}


}
