package sec07.exam02_data_read_write;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket();) {	
				serverSocket.bind(new InetSocketAddress("localhost", 5001));
			
			while(true) {
				System.out.println( "[연결 기다림]");
				
				try (Socket socket = serverSocket.accept();) {
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[연결 수락함] " + isa.getHostName());
				
				InputStream is = socket.getInputStream();
				
				byte[] bytes = new byte[100];
				int readByteCount = is.read(bytes);
				String message = null;
				message = new String(bytes, 0, readByteCount, "UTF-8");
				System.out.println("[데이터 받기 성공]: " + message);
				
				OutputStream os = socket.getOutputStream();
				message = "서버가 찾은 정보 이겁니다...";
				os.write(message.getBytes("UTF-8"));
				os.flush();
				System.out.println( "[한 고객 서비스 완료]");
				}
			}
		} catch(Exception e) {}
	}
}
