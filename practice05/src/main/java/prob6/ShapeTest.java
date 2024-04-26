package prob6;

import java.util.ArrayList;
import java.util.List;

public class ShapeTest {

	public static void main(String[] args) {
		List<Shape> list = new ArrayList<Shape>(); //전부 다 해야해.. Shape Resizable 인터페이스
		
		list.add( new Rectangle(5, 6) );
		list.add( new RectTriangle( 6, 2) );
		
		for( Shape shape : list ) {
			System.out.println( "area:" + shape.getArea() );  //math sqrt()
			System.out.println( "perimeter:" + shape.getPerimeter() );
			
			if( shape instanceof Resizable ) {
				Resizable resizable = (Resizable) shape;
				resizable.resize( 0.5 );
				System.out.println( "new area:" + shape.getArea() );
				System.out.println( "new perimeter:" + shape.getPerimeter() );
			}
		}
	}
}