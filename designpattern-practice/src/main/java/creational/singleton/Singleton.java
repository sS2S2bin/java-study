package creational.singleton;

public class Singleton {
	private static Singleton instance = null;

	//private사용해서 외부에서 new 생성자 못하게 만들기 
	private Singleton() {}
	
	//외부에선 getInstance()로 instance 반환
	public static Singleton getInstance() {
		if(instance==null) {
			instance = new Singleton();
		}
		return instance;
	}
	
}
