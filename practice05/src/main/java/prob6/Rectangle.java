package prob6;

public class Rectangle extends Shape implements Resizable {

	public Rectangle(double i, double j) {
		this.width = i;
		this.height = j;
	}

	@Override
	public void resize(double s) {
		this.width = width*s;
		this.height = height*s;
	}

	@Override
	double getArea() {
		return width*height;
	}

	@Override
	double getPerimeter() {
		return (width+height)*2;
	}

}
