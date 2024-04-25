package paint;

public class DrawingApp {

	public static void main(String[] args) {
		Point point1 = new Point(10,20);
//		point.setX(10);
//		point.setY(20);
		
		drawPoint(point1);
		// point.disappear();
		point1.show(false);
		
		ColorPoint point2 = new ColorPoint(100,200,"red");
		 drawPoint(point2); //캐스팅
		// drawColorPoint(point2);
		 //point2.show(true);
		 
		 // drawTriangle(new Triangle());
		 // drawRectangle(new Rectangle());
//		 drawShape(new Triangle());
//		 drawShape(new Rectangle());
//		 drawShape(new Circle());
		 draw(new Triangle());
		 draw(new Rectangle());
		 draw(new Circle());
		 draw(new GraphicText("HelloWorld"));
		 
		 
		 //instanceof 연산자
		 Circle c = new Circle();
		 
		 System.out.println(c instanceof Circle);
		 System.out.println(c instanceof Shape);
		 System.out.println(c instanceof Object);
		 
		 // 오류 : 연산자 우측항이 클래스 인 경우,
		 // 레퍼런스를 하고 있는 class 타입의 hierachy 상위 하위만(위아래/자식부)
		 // instanceof 연산자를 사용할 수 있다. 
		 // System.out.println(c instanceof Point);
		 
		 Object o = new Circle();
		 System.out.println(o instanceof String); 
		 
		 // 연산자 우측항이 인터페이스 인 경우
		 // Hierachy 상관없이 instanceof 연산자를 사용할 수 있다. 
		 System.out.println(c instanceof Drawable);
		 System.out.println(c instanceof Runnable);
		 
	}
	private static void draw(Drawable drawable) {
		// drawable interface기능이 구현된 애들만 들어올 수 있음 
		drawable.draw();
	}
	
	private static void drawShape(Shape shape) {
		shape.draw();
	}
	
	
	private static void drawPoint(Point point) {
		point.show();
	}
	/*
//	private static void drawColorPoint(ColorPoint colorPoint) {
//		colorPoint.show();
//	}
	private static void drawTriangle(Triangle triangle) {
		triangle.draw();
	}
	private static void drawRectangle(Rectangle rectangle) {
		rectangle.draw();
	}
	*/

}
