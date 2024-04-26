package chapter04;

import java.util.Objects;

public class Rect {
	private int w;
	private int h;
	
	public Rect(int w, int h) {
		this.w = w;
		this.h = h;
	}

	@Override
	public String toString() {
		return "Rect [w=" + w + ", h=" + h + "]";
	}

	@Override
	public int hashCode() {
		//return Objects.hash(h, w);
		//비즈니스에서 너비로 같은 조건인지 확인하는걸로 바꾸자고 할때
		return Objects.hash(h*w); 
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rect other = (Rect) obj;
		//비즈니스에서 너비로 같은 조건인지 확인하는걸로 바꾸자고 할때
		return h*w == other.h*other.w;
		//return h == other.h && w == other.w;
	}

	
}
