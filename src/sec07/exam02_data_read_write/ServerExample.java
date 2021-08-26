package sec07.exam02_data_read_write;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
	public static void main(String[] args) {
		
		PrintStream out;
		try {ServerSocket serverSocket = new ServerSocket();		
			out = new PrintStream(System.out, true, "UTF-8");
			serverSocket.bind(new InetSocketAddress("localhost", 5001));
			while(true) {
				out.println( "[연결 기다림]");
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				out.println("[연결 수락함] " + isa.getHostName());
				
				byte[] bytes = null;
				String message = null;
				
				InputStream is = socket.getInputStream();
				bytes = new byte[100];
				int readByteCount = is.read(bytes);
				message = new String(bytes, 0, readByteCount, "UTF-8");
				out.println("[데이터 받기 성공]: " + message);
				
				OutputStream os = socket.getOutputStream();
				message = "서버가 찾은 정보가 이겁니다...";
				bytes = message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				out.println( "[데이터 보내기 성공]");
				
				is.close();
				os.close();
				socket.close();
			}
		} catch(Exception e) {}
	}
}
