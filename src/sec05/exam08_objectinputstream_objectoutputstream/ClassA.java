package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.Serializable;

public class ClassA implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int field1;
	ClassB field2 = new ClassB();	
	static int field3;
	transient int field4;
}
