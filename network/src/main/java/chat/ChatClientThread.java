package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientThread extends Thread {
	private BufferedReader bufferedReader;
	private Socket socket;

	public ChatClientThread(Socket socket2, BufferedReader br) {
		this.socket = socket2;
		this.bufferedReader = br;
	}

	@Override
	public void run() {
		String line;
		try {
			while(true){
			line = bufferedReader.readLine();
			//blocking //nextLine이 개행 떼고 줌
			if("quit".equals(line)) {
				break;
				}
			if(line==null) {
				ChatClient.log("Socket Exception : 빈 문자 입니다.");
				break;
				}
			System.out.println(line);
			}
		} catch (SocketException e) {
			ChatClient.log(""+e);
		}catch (IOException e) {
			ChatClient.log(""+e);
		} finally {
			try {
				if(socket!=null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				ChatClient.log("??"+e);
			}
		}
	}



	

}
