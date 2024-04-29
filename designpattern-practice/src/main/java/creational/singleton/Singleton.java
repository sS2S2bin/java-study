package creational.singleton;

public class Singleton {
	private static Singleton instance = null;

	// new 생성자 못하게 만들기 
	private Singleton() {}
	public static Singleton getInstance() {
		if(instance==null) {
			instance = new Singleton();
		}
		return instance;
	}
	
}
