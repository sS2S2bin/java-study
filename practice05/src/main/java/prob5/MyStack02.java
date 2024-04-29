package prob5;

import java.util.Arrays;

public class MyStack02 {
	private int top;
	private Object[] buffer;

	
	public MyStack02(int stacksize) {
		this.top = -1;
		this.buffer = new Object[stacksize];
	}
	 
	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public Object[] getBuffer() {
		return buffer;
	}

	public void setBuffer(Object[] buffer) {
		this.buffer = buffer;
	}

	
	public void resize() {
		//2배로 긴 배열 생성
	 	Object[] tmp = new Object[buffer.length*2];
	 	
	 	
	 	//배열 복사 : 하나하나꺼내야함, setBuffer로 하면 짧은 길이의 배열이 들어가게됨
	 	for(int i = 0; i<buffer.length;i++) {
	 		tmp[i]=buffer[i];
	 	}
	 	
	 	setBuffer(tmp); // resize의 리턴값을 void로 
	}
	
	public void push(String s){
	 	// size top 비교 : 들어갈 수 있는지?
		if(top==(buffer.length-1)) {
			resize();
		}
		//코드 중복 줄이기
		setTop(top+1);
	 	buffer[top] = s;
	 	
	 }
	
	
	 public Object pop() throws MyStackException { //내가 만든 예외처리 throw 해줘
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