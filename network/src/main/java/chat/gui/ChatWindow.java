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

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	
	private Socket socket;
	private String name;
	private PrintWriter pw;
	

	public ChatWindow(String name,Socket socket) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.socket = socket;
		this.name = name;
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
		//quit 프로토콜 구현
		pw.println("quit:");
		
		//exit java application
		System.exit(0);
		
	}
	
	private void sendMessage() {
		String message = textField.getText();
		// message가 Null인지 아닌지 확인
		pw.println("message:"+message);
		
		// 보낸다음에 textField 지워
		textField.setText("");
		textField.requestFocus();
		updateTextArea( name + ":"  +message);
		
	}
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	// 여기내부에 chatclient thread를 만들어 
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
				updateTextArea( name + ":"  +message);
				
				String[] tokens = message.split(":");
				if("quit".equals(tokens[0])) {
					break;
				}

			}
				
				
			} 
			catch (IOException e) {
				finish();
				System.out.println(e);
			}
		}
	}
	
}
