package prob5;

import java.util.Arrays;

public class MyStack {
	private int top;
	private String[] buffer;
	private int bufferSize;
	
	public MyStack(int stacksize) {
		this.top = -1;
		this.bufferSize = stacksize;
		this.buffer = new String[stacksize];
	}
	 
	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public String[] getBuffer() {
		return buffer;
	}

	public void setBuffer(String[] buffer) {
		this.buffer = buffer;
	}

	public int getBufferSize() {
		return bufferSize;
	}

	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}
	
	public String[] resize() {
		//2배로 긴 배열 생성
	 	String[] tmp = new String[bufferSize*2];
	 	
	 	
	 	//배열 복사 : 하나하나꺼내야함, setBuffer로 하면 짧은 길이의 배열이 들어가게됨
	 	for(int i = 0; i<bufferSize;i++) {
	 		tmp[i]=buffer[i];
	 	}
	 	
	 	// 버퍼사이즈 늘리기
	 	setBufferSize(bufferSize*2);
	 	return tmp;
	}
	
	public void push(String s){
	 	// size top 비교 : 들어갈 수 있는지?
		if(top<(bufferSize-1)) {
		 	setTop(top+1);
		 	buffer[top] = s;
		}
		else {
			setBuffer(resize());
			//resize 이후 제일 위에 값 push
			setTop(top+1); 
			buffer[top] = s;
		}
	 	
	 }
	
	
	 public String pop() throws MyStackException{ //내가 만든 예외처리 throw 해줘
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