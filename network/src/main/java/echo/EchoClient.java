package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
	public static final String SERVER_IP = "127.0.0.1";
	
	private static void log(String message) {
		System.out.println("[EchoClient]"+message);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;
		try {
			
			socket = new Socket();
			
			socket.connect(new InetSocketAddress(SERVER_IP,EchoServer.PROT));
			
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true); // SocketStream
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8")); //얜 개행단위로 읽어와서 auto flush 필요 x
			
			while(true) {
				
				System.out.print(">>");
				String line = scanner.nextLine(); //nextLine이 개행 떼고 줌
				if("exit".equals(line)) {
					break;
				}
				
				pw.println(line);
				String data = br.readLine(); //blocking
				if(data==null) {
					log("suddently closed by server");
					break;
				}
				System.out.println("<<"+data);
				
			}
		}catch(IOException e) {
			log("error:"+e);
			
		}finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
