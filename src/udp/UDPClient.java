package udp;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import serialisation.Person;
import serialisation.SerialiseToByteArray;

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
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket();
			InetAddress aHost = InetAddress.getByName(args[0]);
			int serverPort = Integer.parseInt(args[1]);
			
			Person person = new Person("Smithe", "London", 1934);
			byte[] message = SerialiseToByteArray.buildBAOutputStream(person);
			
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
