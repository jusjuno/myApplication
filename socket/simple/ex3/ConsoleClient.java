package khd.socket.simple.ex3;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConsoleClient {
	
	public static void main(String[] args) {
		
		Socket socket = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		
		try {
			// 1. 서버와 연결하는 소켓 객체 생성
			socket = new Socket("127.0.0.1", 9876);
			
			// 2. 서버와 데이터를 주고받기 위한 스트림 형성
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
			
			// 무한 루프
			while (true) {
			
				System.out.print("Client input Message : ");
				String message = TalkStatement.readString();
				
				// 3. 키보드로부터 읽어 들인 데이터를 서버에게 전송
				// 3번과 4번의 순서 때문에 Client가 먼저 전송해야 Sever에서 전송되는 메세지가 출력된다.
				dos.writeUTF(message);
				
				// 4. 스트림을 통해 데이터를 읽어 들임
				System.out.println("Server Message : " + dis.readUTF());
			}// while end
			
		} catch (Exception e) {
			try {
				// 스트림 객체와 소켓 객체 해제
				dos.close();
				dis.close();
				socket.close();
			} catch (IOException io) {
				System.out.println(io);
			}
		}// catch end
	}// main end
} 
