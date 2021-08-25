package sec04.exam04_file_writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
	public static void main(String[] args) throws Exception {
		
		File file = new File("C:/Temp/Dir/file.txt");	
		
		try(FileWriter fw = new FileWriter(file)){		
			fw.write("FileWriter는 한글로된 4" + "\n");
			fw.write("문자열을 바로 출력할 수 있다." + "\n");
	//		fw.flush();
			System.out.println("파일에 저장되었습니다.");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}

