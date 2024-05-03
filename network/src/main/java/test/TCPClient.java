package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class TCPClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 4000;
	
	public static void main(String[] args) {
		
		Socket socket = null;
		
		try {
			//1. socket 생성
			socket =  new Socket();
			
			//1-1. 소켓 버퍼 사이즈 확인
			int rcvBufferSize = socket.getReceiveBufferSize();
			int sndBufferSize = socket.getSendBufferSize();
			System.out.println(rcvBufferSize+":"+sndBufferSize);
			
			//1-2. 소켓 버퍼 사이즈 변경
			socket.setReceiveBufferSize(1024*10);
			socket.setSendBufferSize(1024*10);
			
			rcvBufferSize = socket.getReceiveBufferSize();
			sndBufferSize = socket.getSendBufferSize();
			System.out.println(rcvBufferSize+":"+sndBufferSize);
			
			//1-3. SO_NODELAY(Nagle Alogorithm Off)
			socket.setTcpNoDelay(true);
			
			
			//1-4. SO_TIMEOUT
			//데이터 읽기에 타임아웃 설정
			socket.setSoTimeout( 3000 );
			
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
			
			//6. 데이터 쓰기 
			//SO_TIMEOUT 테스트
			try {
				Thread.sleep(40000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			data = new String(buffer,0,readByteCount,"utf-8");
			// 이걸 inputStreamReader 한테 맡겨
			
			System.out.println("[client] received: "+data);
			
			
			
		} catch (SocketTimeoutException e) {
			System.out.println("[client] timeout :"+e);
		}catch (SocketException e) {
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
