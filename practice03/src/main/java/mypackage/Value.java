package mypackage;

public class Value {
	public int val; // 이러면 정보 은닉에 위배
	public Value(int val) {
		this.val = val ; // 의도 : 바깥 val값에 인풋 val를 넣을래
	}
}
