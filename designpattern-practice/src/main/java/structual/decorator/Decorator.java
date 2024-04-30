package structual.decorator;

public abstract class Decorator extends Component {
	protected Component component;
	// 보조스트림을 만들려면 스트림을 앞에 넣어줘야해
	public Decorator(Component component) {
		this.component = component;
	}
	
	// 뭘 decorate 해야할지 몰라서 아래 함수 오버라이딩 불가
	//@Override
	//public String operation() {
	//	return null;
	//}

}
