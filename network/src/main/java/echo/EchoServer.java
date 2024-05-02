package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static final int PORT = 4000;


	public static void log(String message) {
		System.out.println("[EchoServer]"+message);
	}
	
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			
			serverSocket.bind(new InetSocketAddress("0.0.0.0",PORT),10);
			log("starts [port:"+PORT+"]");
			
			while(true) {
				Socket socket = serverSocket.accept();
				new EchoRequestHandler(socket).start();
			}
			
			
		} catch (IOException e) {
			System.out.println("[server] error : "+e);
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
