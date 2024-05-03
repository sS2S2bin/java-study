package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickname;
	private Socket socket;
	public List<PrintWriter> listWriters;

	
	public ChatServerThread( Socket socket, List<PrintWriter> listWriters ) {
	   this.socket = socket;
	   this.listWriters = listWriters;
	}

	@Override
	public void run() {	
		PrintWriter printWriter = null;
		try {
			//1. Remote Host Information
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remotePort = inetRemoteSocketAddress.getPort();
			ChatServer.log("connected by client[" +remoteHostAddress +":" + remotePort + "]");
			
			
			//2. 스트림 얻기
			BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( socket.getInputStream(), StandardCharsets.UTF_8 ) );
			printWriter = new PrintWriter( new OutputStreamWriter( socket.getOutputStream(), StandardCharsets.UTF_8 ), true );
			
			
			
			//3. 요청 처리 			
			while( true ) {
			   String request = bufferedReader.readLine();
			   if( request == null ) {
			      ChatServer.log( "클라이언트로 부터 연결 끊김" );
			      doQuit( printWriter ); // 클라이언트가 quit을 보내지 않고 소켓을 닫은 경우 
			      break;
			   }
		
			   // 4. 프로토콜 분석
			   String[] tokens = request.split( ":" );
				
			   if( "join".equals( tokens[0] ) ) {
		
			      doJoin( tokens[1], printWriter );
		
			   } else if( "message".equals( tokens[0] ) ) {
			      
			      doMessage( tokens[1] );
		
			   } else if( "quit".equals( tokens[0] ) ) {
			      
			      doQuit(printWriter);
			      break;
		
			   } else {
		
			      ChatServer.log( "에러:알수 없는 요청(" + tokens[0] + ")" );
			   }
			}
		} catch(SocketException e) {
			doQuit(printWriter);
			ChatServer.log(" 비정상 종료 suddenly closed by client : "+e);
		}catch (IOException e) {
			doQuit(printWriter);
			ChatServer.log(""+e);
		}finally {
			if (socket !=null && !socket.isClosed()) {
				try {
					socket.close();
				} catch (IOException e) {
					ChatServer.log("error : "+e);
				}
			}
		}

	}


	private void doJoin( String nickName, PrintWriter writer ) {
		this.nickname = nickName;
		String data = nickName + "님이 참여하였습니다."; 
		broadcast( data );
		
		/* writer pool에  저장 */
		addWriter( writer );
		
		//ack
		writer.println( "join:ok" );
		writer.flush();

	}
			
	private void addWriter( PrintWriter writer ){
	   synchronized( listWriters ) {
	      listWriters.add( writer );
	   }
	}

	private void doQuit(  PrintWriter writer ) {
		removeWriter( writer );
		String data = this.nickname + "님이 퇴장 하였습니다."; 
		broadcast( data );
	}

	private void removeWriter( Writer writer ) {
		listWriters.remove(writer);
		//이거 할 필요 X 참조하는 애가 사라지면 GC가 알아서 처리해줌.
//		try {
//			for(Writer writers : listWriters) {
//				if (writers.equals(writer) && writer!=null) {
//					writer.close();
//				}
//			}
//			
//		} catch (IOException e) {
//			ChatServer.log("remove writer : "+e);
//		}
	}


	private void doMessage(String string) {
		// 잘 구현하시요 ^^
		broadcast(nickname+":"+string);
		
	}
	
	// 서버 모든 클라이언트에게 메세지 보내는브로드캐스트 메소드 
	private void broadcast( String data ) {
		// 모두에게 보내야하니 동기화 처리 
		synchronized( listWriters ) {
			for( Writer writer : listWriters ) { 
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println( data );
				printWriter.flush();
				}
			}
		}

	

}
