package chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import chat.ChatServer;

public class ChatClientApp {

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;
		// 여기서 소켓 다 열고 연결 다 하고
		try {
	   //socket 생성
		socket = new Socket();
	   //연결
		socket.connect(new InetSocketAddress("0.0.0.0", ChatServer.PORT));
		
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8")); //얜 개행단위로 읽어와서 auto flush 필요 x
		
		while( true ) {
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			if (name.isEmpty()) {
				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			}else {
				pw.println("join:"+name); //여기서 join
			   String ack = br.readLine();
			   if("join:ok".equals(ack)) {
				   new ChatWindow(name, socket).show(); 
				   //System.out.println("입장을 환영합니다. 채팅을 시작하세요.");
			   }
				break;
			}
		}
		scanner.close();
		

		} catch (UnsupportedEncodingException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
