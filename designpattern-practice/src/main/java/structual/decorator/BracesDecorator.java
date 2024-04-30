package structual.decorator;

public class BracesDecorator extends Decorator {

	public BracesDecorator(Component component) {
		super(component);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String operation() {
		String text = component.operation();
		
		return "{" + text + "}";
	}

}
