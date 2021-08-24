package sec02.exam01_inputstream_read;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample2 {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("C:/Temp/test.txt");
		int readByteNo;
		byte[] readBytes = new byte[3];
		var data = new StringBuilder();
		while( true ) {
			readByteNo = is.read(readBytes);
			if(readByteNo == -1) break;
			data.append(new String(readBytes, 0, readByteNo));
		}
		System.out.println(data);
		is.close();
	}

}
