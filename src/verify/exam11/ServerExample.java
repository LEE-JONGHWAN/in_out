package verify.exam11;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class ServerExample {
	public static void main(String[] args) throws Exception {
		try(ServerSocket serverSocket = new ServerSocket();) {		
		serverSocket.bind(new InetSocketAddress("localhost", 5001));
		System.out.println("[서버 시작]");
		
		while(true) {
			try {
				Socket socket = serverSocket.accept();
	
				InputStream is = socket.getInputStream();

				byte[] bytes = new byte[1000];
				int readByteCount = -1;
				
				readByteCount = is.read(bytes);
				String fileName = new String(bytes, Charset.forName("UTF-8"));
				fileName = fileName.trim();
				System.out.println("[파일 받기 시작] " + fileName);
				
				File oFile = new File("C:/Temp/" + fileName);
				try(var fos = new BufferedOutputStream(new FileOutputStream(oFile));) {
					while ((readByteCount = is.read(bytes)) != -1) {
						fos.write(bytes, 0, readByteCount);
					}
				
					System.out.println("[파일 받기 완료]");
				}
				
			} catch(Exception e) {
				break;
			}
		}
		serverSocket.close();
		System.out.println("[서버 종료]");
		}
	}
}
