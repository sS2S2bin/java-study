package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.Scanner;


public class ChatClient {
	public static final String SERVER_IP = "127.0.0.1";

	public static void log(String message) {
		System.out.println("[ChatClient]"+message);
	}
	

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		
		try {
		   //1. 키보드 연결
			scanner = new Scanner(System.in);
		   //2. socket 생성
			socket = new Socket();
		   //3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			
		   //4. reader/writer 생성
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true); // SocketStream
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8")); //얜 개행단위로 읽어와서 auto flush 필요 x
			
		   //5. join 프로토콜
		   System.out.print("닉네임>>" );
		   String nickname = scanner.nextLine();
		   printWriter.println( "join:" + nickname ); 
		   printWriter.flush();
		   
		   
		   String ack = br.readLine();
		   if("join:ok".equals(ack)) {
			   System.out.println("입장을 환영합니다. 채팅을 시작하세요.");
		   }
		   

		   //6. ChatClientReceiveThread 시작
		   new ChatClientThread( socket, br ).start();

		   //7. 키보드 입력 처리
		   while( true ) {
		      String input = scanner.nextLine();
						
		      if( "quit".equals( input )) {
		          // 8. quit 프로토콜 처리
				   printWriter.println( "quit:" + nickname ); 
		          break;
		      } else {
		          // 9. 메시지 처리
				   printWriter.println( "message:" + input ); 
		      }
		   }
			
			
		}catch(SocketException e) {
			//log("Socket Exception"+e);
		}
		catch(IOException e) {
			//log("error:"+e);
			
		}finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
					scanner.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}
}
