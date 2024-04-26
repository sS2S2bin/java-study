package prob05;

public class MyBase extends Base {
	// Base에서 뭘 오버라이드 할지 고민해봐라 
	public void noon() {
		System.out.println("오후도 낮과 마찬가지로 일해야합니다.");
	}
	@Override
	public void day(){
		System.out.println("낮에는 열심히 일하자!");
	}
	
	@Override
	public void service(String state){
		if( state.equals( "오후" ) ) {
			noon();
		}
		else {
			super.service(state);
		}
	}
}
