package sec04.exam04_file_reader;

import java.io.FileReader;
import java.io.IOException;

import sec00.Consts;

public class FileReaderExample {
	public static void main(String[] args) throws Exception {
		//formatter:off
		try(FileReader fr = new FileReader(Consts.CH18 +
				"/sec04/exam04_file_reader/FileReaderExample.java")){
			int readCharNo;
			char[] cbuf = new char[100];
			
			while ((readCharNo=fr.read(cbuf)) != -1) {
				String data = new String(cbuf, 0, readCharNo);
				System.out.print(data);
	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

