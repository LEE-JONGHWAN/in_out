package sec08.exam01_udp;

import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class UdpSendExample {
	public static void main(String[] args) throws Exception {
		DatagramSocket datagramSocket = new DatagramSocket();
		PrintStream out = new PrintStream(System.out, true, 
				Charset.forName("UTF-8"));
		out.println("[발신 시작]");
		
		for(int i=1; i<3; i++) {
			String data = "메시지" + i;
			byte[] byteArr = data.getBytes("UTF-8");
			DatagramPacket packet = new DatagramPacket(
				byteArr, byteArr.length, 
				new InetSocketAddress("localhost", 5001)
			);
			
			datagramSocket.send(packet);
			out.println("[보낸 바이트 수]: " + byteArr.length + " bytes");
		}
		
		out.println("[발신 종료]");
		
		datagramSocket.close();
	}
}
