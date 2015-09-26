package udp;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import serialisation.DeserialiseFromByteArray;
import serialisation.Person;
import serialisation.SerialiseToByteArray;

public class UDPServer {
	public static void main(String args[]) {
		DatagramSocket aSocket = null;
		try {
			int portNumber = Integer.parseInt(args[0]);
			aSocket = new DatagramSocket(portNumber);
			
			byte[] buffer = new byte[SerialiseToByteArray.sizeOfPersonMessage()];
			
			System.out.println("Listening on port " + portNumber);
			while (true) {
				DatagramPacket request = new DatagramPacket(buffer,
						buffer.length);
				aSocket.receive(request);
				
				Person personneReceived = DeserialiseFromByteArray.readFromByteArray(request.getData());
				System.out.println(personneReceived);
				
				
				/*
				DatagramPacket reply = new DatagramPacket(request.getData(),
						request.getLength(), request.getAddress(), request
								.getPort());
				aSocket.send(reply);
				*/
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
