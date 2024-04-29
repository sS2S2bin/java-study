package prob5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyStack03<T> {
	private int top;
	private T[] buffer;

	/*
	MyStack03<String> m3 = new MyStack03();
	MyStack03<String> m3 = new MyStack03(String.class, 3); 
	generic은 컴파일때 만들어지니까 
	
	*/
	
	@SuppressWarnings("unchecked")
	public MyStack03(int stacksize) { //Class<?> klass ,
		this.top = -1;
		this.buffer = (T[]) new Object[stacksize];
		// this.buffer = (T[]) Array.newInstance(klass, stacksize); // getClass() 절대 안돼
		// generic type T 사용 불가 T[] XX
		// 그래서 캐스팅 기법을 사용
	}
	 
	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public T[] getBuffer() {
		return buffer;
	}

	public void setBuffer(T[] buffer) {
		this.buffer = buffer;
	}

	@SuppressWarnings("unchecked")
	public void resize() {
		//2배로 긴 배열 생성
		T[] tmp = (T[]) new Object[buffer.length*2];
	 	
	 	
	 	//배열 복사 : 하나하나꺼내야함, setBuffer로 하면 짧은 길이의 배열이 들어가게됨
	 	for(int i = 0; i<buffer.length;i++) {
	 		tmp[i]=buffer[i];
	 	}
	 	
	 	setBuffer(tmp); // resize의 리턴값을 void로 
	}
	
	public void push(T s){
	 	// size top 비교 : 들어갈 수 있는지?
		if(top==(buffer.length-1)) {
			resize();
		}
		//코드 중복 줄이기
		setTop(top+1);
	 	buffer[top] = s;
	 	
	 }
	
	
	 public T pop() throws MyStackException { //내가 만든 예외처리 throw 해줘
		 int tmpTop = getTop();
		 
		 if(isEmpty()) {
			 throw new MyStackException();
		 }else {
			 setTop(top-1);
			 return buffer[tmpTop]; //이전 top을 보여줘야함
		 }
	 }
	 
	 public boolean isEmpty(){
		 return top == -1;
	 	
	 }

}