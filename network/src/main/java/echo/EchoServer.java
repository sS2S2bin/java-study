package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	public static final int PROT = 4000;


	private static void log(String message) {
		System.out.println("[EchoServer]"+message);
	}
	
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			
			serverSocket.bind(new InetSocketAddress("0.0.0.0",PROT),10);
			
			
			Socket socket = serverSocket.accept(); //blocking
			
			
			
			// data 통신 
			try {
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remotePort = inetRemoteSocketAddress.getPort();
			log("connected by client[" +remoteHostAddress +":" + remotePort + "]");
			
			
			
			//InputStream is = socket.getInputStream();
			//OutputStream os = socket.getOutputStream();
			
			// 쓸 때
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true); // SocketStream
			// 읽을 때
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8")); //얜 개행단위로 읽어와서 auto flush 필요 x
			

			while(true) {
				String data = br.readLine(); //blocking
				
				if(data==null) {
					log("successfully closed by client");
					break;
				}
				
				log("received: "+data);
				
				pw.println(data); //outputstreamwriter가 getBytes 작업해줌
			}
	
			}catch(SocketException e) {
				log(" 비정상 종료 suddenly closed by client : "+e);
			}
			catch (IOException e) {
				log("error : "+e);
			}finally {
				if (socket !=null && !socket.isClosed()) {
					try {
						socket.close();
					} catch (IOException e) {
						log("error : "+e);
					}
				}
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
