package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class TCPClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 4000;
	
	public static void main(String[] args) {
		
		Socket socket = null;
		
		try {
			//1. socket 생성
			socket =  new Socket();

			//2. 서버연결
			socket.connect(new InetSocketAddress(SERVER_IP,SERVER_PORT));
		
		
			//3. IO Stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			
			//4. 쓰기
			String data = "hello world";
			os.write(data.getBytes("utf-8")); 
		
			
			//5. 읽기
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer);
			if(readByteCount == -1) {
				System.out.print("[client] closed by server");
				return;
			}
			
			data = new String(buffer,0,readByteCount,"utf-8");
			// 이걸 inputStreamReader 한테 맡겨
			
			System.out.println("[client] received: "+data);
			
			
			
		} catch (SocketException e) {
			System.out.println("[client] suddenly closed by server :"+e);
		}catch (IOException e) {
			System.out.println("[client] error:"+e);
		}finally {
			try {
				if(socket !=null && !socket.isConnected()) {
					socket.close();
					System.out.println("클라이언트 서버 종료 요청");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
