package structual.decorator;

public class Client {

	public static void main(String[] args) {
		System.out.println(new ConcreteComponent("Hello World").operation());
		//프로그램은 보조스트림을 쓰는거임
		System.out.println(new BracesDecorator(new ConcreteComponent("hello!")).operation());
		System.out.println(new ParenthesesDecorator(new BracesDecorator(new ConcreteComponent("jakjdkfhkajweworld"))).operation());
		System.out.println(new BracesDecorator (new ParenthesesDecorator(new ConcreteComponent("jakjdkfhkajweworld"))).operation());
	}

}
