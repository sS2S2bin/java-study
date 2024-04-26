package prob6;

public class RectTriangle extends Shape {
	public RectTriangle(double i, double j) {
		this.width = i;
		this.height = j;
	}

	@Override
	double getArea() {
		return width*height*0.5;
	}

	@Override
	double getPerimeter() {
		double tmp = Math.pow(width, 2) + Math.pow(height, 2);
		return Math.sqrt(tmp)+width+height;
	}
}
