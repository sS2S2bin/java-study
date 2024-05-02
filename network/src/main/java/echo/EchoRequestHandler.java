package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoRequestHandler extends Thread {
	private Socket socket; // socket 받아야하니까
	
	public EchoRequestHandler(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// data 통신 
		try {
		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
		int remotePort = inetRemoteSocketAddress.getPort();
		EchoServer.log("connected by client[" +remoteHostAddress +":" + remotePort + "]");
		
		
		
		//InputStream is = socket.getInputStream();
		//OutputStream os = socket.getOutputStream();
		
		// 쓸 때
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true); // SocketStream
		// 읽을 때
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8")); //얜 개행단위로 읽어와서 auto flush 필요 x
		

		while(true) {
			String data = br.readLine(); //blocking
			
			if(data==null) {
				EchoServer.log("successfully closed by client");
				break;
			}
			
			EchoServer.log("received: "+data);
			
			pw.println(data); //outputstreamwriter가 getBytes 작업해줌
		}

		}catch(SocketException e) {
			EchoServer.log(" 비정상 종료 suddenly closed by client : "+e);
		}
		catch (IOException e) {
			EchoServer.log("error : "+e);
		}finally {
			if (socket !=null && !socket.isClosed()) {
				try {
					socket.close();
				} catch (IOException e) {
					EchoServer.log("error : "+e);
				}
			}
		}
		
	}
	
}
