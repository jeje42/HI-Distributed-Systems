package serialisation;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerialiseToByteArray {
	public static byte[] buildBAOutputStream(Object o){
		ByteArrayOutputStream os = new ByteArrayOutputStream();

		try {
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(o);
			oos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return os.toByteArray();
	}
	
	public static int sizeOfPersonMessage(){
		return buildBAOutputStream(new Person(new String(new byte[20],0,20), new String(new byte[300],0,300), 1934)).length;
	}
}
