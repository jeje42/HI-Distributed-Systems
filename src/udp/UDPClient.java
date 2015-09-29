package udp;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import serialisation.Person;
import serialisation.SerialisationFramework;

public class UDPClient {
	
	/**
	 * Arguments :
	 * <ul>
	 * 	<li> hostname/IP adress
	 * 	<li> port number
	 * </ul>
	 * @param args
	 */
	public static void main(String args[]) {
		if(args.length != 2){
			System.out.println("You should give two arguments : the hostname/IP adress and the port number.");
			return;
		}
		
		
		DatagramSocket aSocket = null;
		SerialisationFramework serialisationFramework = new SerialisationFramework();
		
		try {
			aSocket = new DatagramSocket();
			InetAddress aHost = InetAddress.getByName(args[0]);
			int serverPort = Integer.parseInt(args[1]);
			
			Person person = new Person("Smithe", "London", 1934);
			
			byte[] message = serialisationFramework.buildByteMessage(person);
			
			DatagramPacket request = new DatagramPacket(message, message.length, aHost, serverPort);
			aSocket.send(request);
			
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
