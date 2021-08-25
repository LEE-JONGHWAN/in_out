package sec05.exam03_bufferedinputstream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import sec00.Consts;

public class BufferedInputStreamExample {
	public static void main(String[] args) throws Exception {
		long start = 0;
		long end = 0;

		//formatter:off
		String imageFile = Consts.CH18 +
				"/sec05/exam03_bufferedinputstream/forest.jpg";
		try(FileInputStream fis1 = new FileInputStream(imageFile)){
			start = System.currentTimeMillis();
			while(fis1.read() != -1) {
			}
			end = System.currentTimeMillis();
			
			System.out.println("사용하지 않았을 때: " + (end-start) + "ms");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try(
			FileInputStream fis2 = new FileInputStream(imageFile);
			BufferedInputStream bis = new BufferedInputStream(fis2)){
			
			start = System.currentTimeMillis();
			while(bis.read() != -1) {
			}
			end = System.currentTimeMillis();
			
			System.out.println("사용했을 때: " + (end-start) + "ms");
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

