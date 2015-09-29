package udp;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import serialisation.Person;
import serialisation.SerialisationFramework;

public class UDPServer {
	public static void main(String args[]) {
		if(args.length != 1){
			System.out.println("You should give one argument corresponding to the port number of the listening server.");
			return;
		}
		
		DatagramSocket aSocket = null;
		SerialisationFramework serialisationFramework = new SerialisationFramework();
		
		try {
			int portNumber = Integer.parseInt(args[0]);
			aSocket = new DatagramSocket(portNumber);
			
			/**
			 * buffer to fill the request
			 */
			byte[] buffer = new byte[serialisationFramework.sizeOfPersonMessage()];
			
			System.out.println("Listening on port " + portNumber);
			
			/**
			 * Listening loop
			 */
			while (true) {
				/**
				 * Request we can expect to receive.
				 */
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				
				aSocket.receive(request);
				
				/**
				 * Deserialize the information received
				 */
				Person personneReceived = (Person)serialisationFramework.readFromByteArray(request.getData());
				
				
				System.out.println(personneReceived);
				
			}
		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			if (aSocket != null)
				aSocket.close();
		}
	}
}
