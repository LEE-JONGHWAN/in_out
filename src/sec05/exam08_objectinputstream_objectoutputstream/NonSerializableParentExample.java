package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class NonSerializableParentExample {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		try(FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");){
		
		try(ObjectOutputStream oos = new ObjectOutputStream(fos);
				ObjectInputStream ois = new ObjectInputStream(fis);){
				
					Child child = new Child();
			
					child.field1 = "홍길동";
					child.field2 = "홍삼fdf";
					oos.writeObject(child);
					oos.flush();	
		}
					Child v = (Child) ois.readObject();
					
					System.out.println("field1: " + v.field1);
					System.out.println("field2: " + v.field2);
					ois.close(); fis.close();
		}
	}
}
