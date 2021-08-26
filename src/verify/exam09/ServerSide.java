package verify.exam09;

import java.io.IOError;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {
	public static void main(String[] args) throws IOException {
		try(ServerSocket ss = new ServerSocket(5001);
				) {
			try(Socket socket = ss.accept();){
				System.out.println("연결됨!");
			}
		}
	}
}
