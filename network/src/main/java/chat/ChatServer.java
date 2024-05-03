package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	public static final int PORT = 8000;
	
	public static void log(String message) {
		System.out.println("[ChatServer]"+message);
	}

	public static void main(String[] args) { // pool 여기서 관리 
		// 0. writer pool
		 List<PrintWriter> listWriters = new ArrayList<PrintWriter>(); 


		// 1. 서버 소겟 생성
		ServerSocket serverSocket = null ;
		try {
			serverSocket = new ServerSocket();
			
			// 2. 바인딩
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind( new InetSocketAddress( hostAddress, PORT ) );			
			log( "연결 기다림 " + hostAddress + ":" + PORT );

			// 3. 요청 대기 
			while( true ) {
			   Socket socket = serverSocket.accept();
			   new ChatServerThread( socket, listWriters ).start();
			}

			
		}catch(SocketException e) {
			log("Socket Exception"+e);
		} catch (IOException e) {
			log("[server] error "+e);
		}finally {
			if (serverSocket !=null && !serverSocket.isClosed()) {
				try {
					serverSocket.close();
					System.out.println("socket 닫힘");
				} catch (IOException e) {
					System.out.println("[server] error : "+e);
				}
			}
		}

	}

}
