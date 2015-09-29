package serialisation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialisationFramework {
	public byte[] buildByteMessage(Object o){
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
	
	public int sizeOfPersonMessage(){
		return this.buildByteMessage(new Person(new String(new byte[20],0,20), new String(new byte[300],0,300), 1934)).length;
	}
	
	public Object readFromByteArray(byte[] b){
		ByteArrayInputStream is = new ByteArrayInputStream(b);
		ObjectInputStream ois;
		
		try {
			ois = new ObjectInputStream(is);
			Object deserialisedObject = ois.readObject();
			ois.close();
			
			return deserialisedObject;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
