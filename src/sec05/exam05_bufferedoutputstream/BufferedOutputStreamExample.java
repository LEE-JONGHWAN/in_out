package sec05.exam05_bufferedoutputstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import sec00.Consts;

public class BufferedOutputStreamExample {
	public static void main(String[] args) throws Exception {
//		FileInputStream fis = null;
//		FileOutputStream fos = null;
//		BufferedInputStream bis = null;
//		BufferedOutputStream bos = null;
		
		int data = -1;
		long start = 0;
		long end = 0;
		
		String imagefile = Consts.CH18 +
				"/sec05/exam05_bufferedoutputstream/forest.jpg";
		
		try( var fis = new FileInputStream(imagefile);
			 var bis = new BufferedInputStream(fis);
			 var fos = new FileOutputStream("C:/Temp/forest.jpg")) {	
		
		start = System.currentTimeMillis();
		while((data = bis.read()) != -1) {
			fos.write(data); // 바이트 출력
			fos.flush();
		}
		end = System.currentTimeMillis();
		fos.close(); 	bis.close();  fis.close();
		
		System.out.println("사용하지 않았을 때: " + (end-start) + "ms");
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try ( var fis = new FileInputStream(imagefile);
		var bis = new BufferedInputStream(fis);
		var fos = new FileOutputStream("C:/Temp/forest.jpg");		
		var bos = new BufferedOutputStream(fos)){
		
		start = System.currentTimeMillis();
		while((data = bis.read()) != -1) {
			bos.write(data); // (8K)버퍼 단위 출력
		}
		bos.flush();
		end = System.currentTimeMillis();
		
		bos.close(); fos.close(); 	bis.close(); fis.close();
		
		System.out.println("사용했을 때: " + (end-start) + "ms");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

