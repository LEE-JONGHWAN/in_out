package sec04.exam03_fileoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

import sec00.Consts;

public class FileOutputStreamExample {
	public static void main(String[] args) throws Exception {
		
		String originalFileName = Consts.CH18 +
				"/sec04/exam03_fileoutputstream/house.jpg";
		String targetFileName = "C:/Temp/house.jpg";
		
		try(var fis = new FileInputStream(originalFileName);
			var fos = new FileOutputStream(targetFileName)){
		
		int readByteNo;
		byte[] readBytes = new byte[100];
		while( (readByteNo = fis.read(readBytes)) != -1 ) {
			fos.write(readBytes, 0, readByteNo);
		}
		
//		fos.flush();
		System.out.println("복사가 잘 되었습니다.");
	} catch(IOException e) {
		Logger.getGlobal().warning("주택 사진 파일 없는 오류 발생...");
		e.printStackTrace();
	}
  }
}

