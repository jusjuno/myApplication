package khd.socket.simple.ex3;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class ConsoleServer {
	
	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket socket = null;
		
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			// 1. 대표 포트 9876을 지닌 ServerSocket 객체 생성
			server = new ServerSocket(9876);
			
			System.out.println("Wait Client.........");
			
			// 2. 클라이언트의 접속을 기다림
			socket = server.accept(); 
			
			System.out.println("Client Connection Success");
			System.out.println();
			
			// 3. 클라이언트와 데이터를 주고받기 위한 입출력 스트림 생성
			// InputStream is = socket.getInputStream();
			// OutputStream os = socket.getOutputStream();
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			
			// 무한 루프
			while (true) {
			
				// 4. 데이터를 읽어 들임
				System.out.println("Client Message : " + dis.readUTF());
				System.out.print("Server input message : ");
				String message = TalkStatement.readString();
				
				// 5. 키보드로부터 읽어들인 데이터를 클라이언트에게 전송
				dos.writeUTF(message);
			}// while end
			
		} catch (Exception e) {
		
			try {
				// 스트림과 소켓 객체를 해제하고 자원 반납
				dis.close();
				dos.close();
				socket.close();
			} catch (IOException io) {
				System.out.println(io);
			}// catch end
			
		}// catch end
		
	}// main end
}

