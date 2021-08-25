package sec07.exam02_data_read_write;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExample {
	public static void main(String[] args) {
		
		try (Socket socket = new Socket();) {
			System.out.println( "[연결 요청]");
			socket.connect(new InetSocketAddress("localhost", 5001), 10000);
			System.out.println( "[연결 성공]");
			
			
			try (OutputStream os = socket.getOutputStream();
					InputStream is = socket.getInputStream();){
				String message = "Hello Server";
				
				os.write(message.getBytes("UTF-8"));
				os.flush();
				System.out.println( "[데이터 보내기 성공]");
				
				byte[] bytes = new byte[100];
				int readByteCount = is.read(bytes);
	
				message = new String(bytes, 0, readByteCount, "UTF-8");
				System.out.println("[데이터 받기 성공]: " + message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}