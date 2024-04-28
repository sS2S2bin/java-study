package prob6;

public class RectTriangle extends Shape {
	public RectTriangle(double i, double j) {
		this.width = i;
		this.height = j;
	}

	@Override
	protected double getArea() {
		return width*height*0.5;
	}

	@Override
	protected double getPerimeter() {
		double tmp = Math.pow(width, 2) + Math.pow(height, 2);
		return Math.sqrt(tmp)+width+height;
	}
}
