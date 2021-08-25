package sec05.exam06_datainputstream_dataoutputstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputOutputStreamExample {
	public static void main(String[] args) throws Exception {
		
		//formatter:off
	try(var fos = new FileOutputStream("C:/Temp/primitive.dat");
			var dos = new DataOutputStream(fos);) {
		dos.writeUTF("홍길동");
		dos.writeDouble(95.5);
		dos.writeShort(1);
		
		dos.writeUTF("감자바");
		dos.writeDouble(90.3);
		dos.writeShort(2);
		dos.flush();
	} catch(Exception e) {
		e.printStackTrace();
	}
	
		
		try (var fis = new FileInputStream("C:/Temp/primitive.dat");
					var dis = new DataInputStream(fis);) {
		for(int i=0; i<2; i++) {
			String name = dis.readUTF();
			double score = dis.readDouble();
			int order = dis.readInt();
			System.out.println(name + " : " + score + " : " + order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}

