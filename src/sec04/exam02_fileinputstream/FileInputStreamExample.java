package sec04.exam02_fileinputstream;

import java.io.FileInputStream;

import sec00.Consts;

public class FileInputStreamExample {
	//@formatter:off
	public static void main(String[] args) {
		try {var fis = new FileInputStream(Consts.CH18 
				+ "/sec04/exam02_fileinputstream/FileInputStreamExample.java");
			int data;
			while ((data = fis.read()) != -1) {
				if( data < -1 || data > 255)
					throw new Exception("이상한 자료 값");
				System.out.write(data);
			}
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
