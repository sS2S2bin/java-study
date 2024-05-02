package httpd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private Socket socket;
	private final String DOCUMENT_ROOT = "./webapp";
	
	public RequestHandler( Socket socket ) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			OutputStream outputStream = socket.getOutputStream();// get IOStream
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			
			InetSocketAddress inetSocketAddress = ( InetSocketAddress )socket.getRemoteSocketAddress(); // logging Remote Host IP Address & Port
			consoleLog( "connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort() );
			
			String request = null;
			while(true) {
				String line = br.readLine();
				if(line==null) {
					break;
				}
				// SimpleHttpServer는 HTTP Header만 처리
				// 빈 스트링 => 이제 바디 시작
				if("".equals(line)) {
					break;
				}
				
				// request header의 첫 줄만 읽
				if(request==null) {
					request = line;
					break;
				}
				
			}
			
			// 요청 처
			consoleLog(request);
			
			String[] tokens = request.split(" ");
			if("GET".equals(tokens[0])) {
				responseStaticResource(outputStream, tokens[1], tokens[2]);
			}else {
				// methods: POST, PUT, DELETE, HEAD, CONNECT
				// SimpleHttpServer 에서는 무시 (400 Bad Request)
				response400Error(outputStream, tokens[2]);
				
			}
			
			

		} catch( Exception ex ) { //여기서 throws된 예외 받을 수 있음 
			consoleLog( "error:" + ex );
		} finally {
			// clean-up
			try{
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}
				
			} catch( IOException ex ) {
				consoleLog( "error:" + ex );
			}
		}			
	}

	private void responseStaticResource(OutputStream outputStream, String url, String protocol) throws IOException {
		//url 읽어서 outputstream으로 폼에 맞게 적어주는거임
		
		//default(welcome) file set
		if("/".equals(url)) {
			url = "/index.html";
		}
		
		File file = new File(DOCUMENT_ROOT + url); //	./webapp/url
		if(!file.exists()) {
			response404Error(outputStream, protocol);
			return;
		}
		// new io
		byte[] body = Files.readAllBytes(file.toPath()); //여기서 발생하는 에러를 throws로 던져버려 
		String contentType = Files.probeContentType(file.toPath());
		
		
		
		outputStream.write((protocol+" 200 OK\r\n").getBytes( "UTF-8" ) );
		outputStream.write(("Content-Type:" +contentType+"; charset=utf-8\r\n").getBytes( "UTF-8" ) );
		outputStream.write( "\n".getBytes() );
		outputStream.write(body);

	}

	private void response400Error(OutputStream outputStream, String protocol) throws IOException {
		
		File file = new File(DOCUMENT_ROOT + "/error/400.html"); //	./webapp/url
		if(!file.exists()) {
			response404Error(outputStream, protocol);
			return;
		}
		// new io
		byte[] body = Files.readAllBytes(file.toPath()); //여기서 발생하는 에러를 throws로 던져버려 
		String contentType = Files.probeContentType(file.toPath());
		
		
		
		outputStream.write((protocol+" 400 Bad Request\n").getBytes( "UTF-8" ) );
		outputStream.write(("Content-Type:" +contentType+"; charset=utf-8\r\n").getBytes( "UTF-8" ) );
		outputStream.write( "\n".getBytes() );
		outputStream.write(body);

		
	}

	private void response404Error(OutputStream outputStream, String protocol) throws IOException {
		
		File file = new File(DOCUMENT_ROOT + "/error/404.html"); //	./webapp/url
	
		// new io
		byte[] body = Files.readAllBytes(file.toPath()); //여기서 발생하는 에러를 throws로 던져버려 
		String contentType = Files.probeContentType(file.toPath());
		
		
		
		outputStream.write((protocol+" 404 File Not Found\n").getBytes( "UTF-8" ) );
		outputStream.write(("Content-Type:" +contentType+"; charset=utf-8\r\n").getBytes( "UTF-8" ) );
		outputStream.write( "\n".getBytes() );
		outputStream.write(body);

		
	}

	public void consoleLog( String message ) {
		System.out.println( "[RequestHandler#" + getId() + "] " + message );
	}
}
