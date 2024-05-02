package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			//1. 서버 소켓 생성
			serverSocket = new ServerSocket();
			
			
			//2. 바인딩(binding)
			// Socket에 InetSocketAddress[InetAddress(IPAddress + Port)]룰 바인딩 한다.
			// IPAddress: 0.0.0.0: 특정 호스트 IP를 바인딩 하지 않는다.
			serverSocket.bind(new InetSocketAddress("0.0.0.0",4000),10);
			
			
			//3. accept
			Socket socket = serverSocket.accept(); //blocking
			
			
			
			// data 통신 
			try {
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remotePort = inetRemoteSocketAddress.getPort();
			System.out.println("[server] connected by client[" +remoteHostAddress +":" + remotePort + "]");
			
			//4. IO Stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			

			while(true) {
				//5. 데이터 읽기
				// int data = is.read(); 이건 한 글자씩
				// 소켓통신은 바이트 단위1!!!!!!
				byte[] buffer = new byte[256];
				int readByteCount = is.read(buffer); //blocking
				
				if(readByteCount==-1) {
					// Closed by Clieent
					System.out.println("[server] successfully closed by client");
					break;
				}
				String data = new String(buffer,0,readByteCount,"UTF-8");
				System.out.println("[server] received: "+data);
				
				
				//6.데이터 쓰기
				os.write(data.getBytes("utf-8"));
			}
	
			}catch(SocketException e) {
				System.out.println("[server] Socket Exception : "+e);
			}
			catch (IOException e) {
				System.out.println("[server] error : "+e);
			}finally {
				if (socket !=null && !socket.isClosed()) {
					try {
						socket.close();
						System.out.println("server socket 닫힘");
					} catch (IOException e) {
						System.out.println("[server] error : "+e);
					}
				}
			}
			
			
			
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
