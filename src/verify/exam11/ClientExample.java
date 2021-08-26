package verify.exam11;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Arrays;

import sec00.Consts;


public class ClientExample {
	public static void main(String[] args) throws Exception {	
		try(Socket socket = new Socket("localhost", 5001);) {
		OutputStream os = socket.getOutputStream();
		PrintStream out = new PrintStream(
				System.out, true, Charset.forName("UTF-8"));
		
		String filePath = Consts.CH18 
				+ "/sec04/exam03_fileoutputstream/house.jpg";
		File file = new File(filePath);
		
		String fileName = file.getName();
		byte[] fileNameBytes = fileName.getBytes("UTF-8");
		fileNameBytes = Arrays.copyOf(fileNameBytes, 100);
		os.write(fileNameBytes);
		
		out.println("[파일 보내기 시작] " + fileName);
		
		try(var fis = new BufferedInputStream(new FileInputStream(file));) {
		byte[] fileAllBytes = fis.readAllBytes();
		
				os.write(fileAllBytes);
				os.flush();
				out.println("[파일 보내기 완료]");
			}
		}
	}
}
