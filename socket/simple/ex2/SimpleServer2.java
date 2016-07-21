package khd.socket.simple.ex2;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date; //java.util.Date

;

public class SimpleServer2 {
	public static  void main( String[] args ) throws Exception { 
	
		// 대표 포트를 지니는 ServerSocket 객체 선언
		ServerSocket serverSocket = null;
		
		// 접속 정보를 지니는 Socket 객체 선언
		Socket socket = null;
		String msg = "Hello, Client 화이팅2222!!";
		
		
		
		// Object 타입으로 데이터를 주고받기 위한 스트림 객체 선언
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		
		
		// 대표 포트 1234를 지니는 ServerSocket 객체 생성
		serverSocket = new ServerSocket( 1234 ); // 가장 먼저 실행되어야 함.
	
		while( true ) { // 무한루프로 Client의 요청을 계속 받을 수 있다.
		
			System.out.println( "Wait Client .........." );
			
			// 클라이언트의 접속을 기다림
			socket = serverSocket.accept();

			// Socket 클래스의 메소드를 이용해 클라이언트가 접속한 클라이언트의 IP 주소를 얻어옴
			System.out.println( "Clinet IP : " + socket.getInetAddress().getHostAddress() );
			System.out.println(socket);
			
			// ObjectOutputStream,InputStream 객체 생성
			// 객체직렬화를 지원하는 ObjectStream 
			oos = new ObjectOutputStream(socket.getOutputStream());  
			ois = new ObjectInputStream(socket.getInputStream());
			
			// 클라이언트로 부터 데이터를 읽어 들임 
			System.out.println( ois.readObject().toString()+ "님이 접속하셨습니다" );
			                            // Object 형을 String 형으로 전환 
			// 클라이언트로 데이터를 순서대로 전송(객체 직렬화)
			oos.writeObject( msg );  // 가장 먼저 전송
			oos.writeObject( new Date() ); // Date 객체를 생성해서 전송
			oos.writeObject( new String( "Java Network Programming" ) );

			// 스트림 객체 해제
			oos.close();
			ois.close();
			
			// 소켓 객체 해제
			socket.close();
		}  //while end
	}
}