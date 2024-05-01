package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			//1. 서버 소켓 생성
			serverSocket = new ServerSocket();
			
			
			//2. 바인딩(binding)
			// Socket에 InetSocketAddress[InetAddress(IPAddress + Port)]룰 바인딩 한다.
			// IPAddress: 0.0.0.0: 특정 호스트 IP를 바인딩 하지 않는다.
			serverSocket.bind(new InetSocketAddress("0.0.0.0",5000),10);
			
			
			//3. accept
			Socket socket = serverSocket.accept(); //blocking
			
			
			System.out.println("연결 완료");
			
			
		} catch (IOException e) {
			System.out.println("[server] error : "+e);
		}finally {
			//stream으로 닫혔을 수 도 있기 떄문에
			//stream도 닫고 이것도 닫으면 에러남. 
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
