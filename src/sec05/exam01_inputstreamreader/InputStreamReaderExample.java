package sec05.exam01_inputstreamreader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderExample { //jhlee
	public static void main(String[] args) throws Exception {
//		InputStream is = System.in;
		
		try(Reader reader = new InputStreamReader(System.in)){	
		
		int readCharNo;
		char[] cbuf = new char[100];
		
		System.out.println("문장 입력:");
		while ((readCharNo=reader.read(cbuf)) != -1) {
			String data = new String(cbuf, 0, readCharNo);
			System.out.println(data);
			System.out.println("문장 입력(종료: ^z):");
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

