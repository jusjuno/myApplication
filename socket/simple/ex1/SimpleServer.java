package khd.socket.simple.ex1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

 

public class SimpleServer {
    public static void main( String[] args ) {
       
        // 서버 정보를 간직하고 제어하는 ServerSocket 
        // 객체를 선언
        ServerSocket server = null;
        
        // 접속에 관한 정보를 간직하고 제어하는 Socket 객체 선언
        Socket socket = null;

        // 클라이언트에게 데이터를 전송하기 위한 스트림 선언
        OutputStream os;
        DataOutputStream dos;

        // 클라이언트에게 보낼 메시지
        String msg = "Hello, Client 화이팅!";
  
        try {
			 // 대표 포트 7777을 가진 서버 객체를 생성
			 server = new ServerSocket( 7777 );  // 0~1024는 예약되어 있어 사용안될 수 있다.
			 System.out.println( "Wait Client......" );

			 // 클라이언트의 접속을 기다림
			 socket = server.accept(); // 여기서 연결되지 않을 때 더이상 실행하지 않고 예외발생
			 System.out.println( "Client Connection Success" );
			 System.out.println( "server socket : " + socket.getInetAddress().getHostAddress() );  // IP 주소만 구한다.
			 
			 // 지금 현재 접속한 클라이언트에게 데이터를 전송하기 위해서 출력 스트림을 형성 
			 os = socket.getOutputStream();
			 dos = new DataOutputStream( os ); // 기본 값의 형태를 그대로 가지고 저장하는 객체
			 dos.writeUTF( msg );
			
			 // 스트림을 해제
			 dos.close();

			 // 서버와 클라이언트의 연결을 맺고 있는 Socket을 
			 // Close 해서 연결을 끊음
			 socket.close();
     
        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {  

            // 여기서 열린 포트를 안 닫아주면, 재부팅 할 때까지 해당 포트가 폐쇄되는 경우가 생긴다. 
            if(socket != null) try { socket.close(); } catch(IOException e) {} 
            if(server != null) try { server.close(); } catch(IOException e) {} 

        } 

    }//main end...
}


