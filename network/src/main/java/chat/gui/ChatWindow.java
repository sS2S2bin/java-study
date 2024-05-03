package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Base64;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	
	private Socket socket;
	private PrintWriter pw;
	

	public ChatWindow(String name,Socket socket) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.socket = socket;
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		//엔터 쳤을 때 메세지 보내는 코드
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				
				if(keyCode==KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
			
			
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		//IOStream 받아오기 >> pw 때문에 scanner 필요 x textfield가 다 해줌
		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);

			//ChatClientThread 생성
			new ChatClientThread(socket).start();
		} catch (UnsupportedEncodingException e1) {
			System.out.println(e1);
		} catch (IOException e1) {
			System.out.println(e1);
		} 
		
	}
	
	private void finish() {
		try {
			if(socket!=null && socket.isClosed()) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		pw.println("quit");
		System.exit(0);	
	}
	
	private void sendMessage() {
		String message = textField.getText();
		
		if(!message.isBlank()) { //isEmpty 와 차이 : blank하면 엔터 스페이스 등 모두 안보내짐
			//base64 byte>base64string
			String encodedStr = Base64.getEncoder().encodeToString(message.getBytes());
			pw.println("message:"+encodedStr);
			// 보낸다음에 textField 지워
			textField.setText("");
			textField.requestFocus();
		}
		
	}
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	// chatClientThread 오직 소켓을 읽는거만 하고, 그 소켓을 textArea보여주는거만 함
	private class ChatClientThread extends Thread{
		private BufferedReader br;
		private Socket socket;

		
		public ChatClientThread(Socket socket1) {
			socket = socket1;
		}
		
		@Override
		public void run() {
			try {
			String message;
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			while(true) {
				message = br.readLine();
				if(message ==null) {
					break;
					}
				updateTextArea(message);
				}
			} catch(SocketException e) {
				System.out.println(e);
			}
			catch (IOException e) {
				System.out.println(e);
			}finally {
				finish();
			}
		}
	}
	
}
