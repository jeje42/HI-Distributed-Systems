package serialisation;

import java.io.*;

public class DeserialiseFromByteArray {
	public static Person readFromByteArray(byte[] b){
		
		ByteArrayInputStream is = new ByteArrayInputStream(b);
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(is);
			Object deserialisedObject = ois.readObject();
			ois.close();
			
			return (Person)deserialisedObject;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

	/**
	 * @param args
	 *
	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("serialisedPersonObject.bin");
			ObjectInputStream ois = new ObjectInputStream(is);
			Object deserialisedObject = ois.readObject();
			ois.close();
			Person deserialisedPerson = (Person)deserialisedObject;
			deserialisedPerson.printValues();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
}
