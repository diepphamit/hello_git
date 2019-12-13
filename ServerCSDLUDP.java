package ThiCuoiKi;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class ServerCSDLUDP {
	public static void main(String[] args) throws Exception{
		DatagramSocket serverSocket = new DatagramSocket(9876);
		System.out.println("Server is started");
		
		
		while(true) {
			byte[] receiveData = new byte[1024];
			byte[] sendData = new byte[1024];
			//create empty packet to receive data from client
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			
			InetAddress IPAddress = receivePacket.getAddress();
			
			int port = receivePacket.getPort();
			
			String request = new String(receivePacket.getData());
			sendData = new KetNoiCSDL().displayUserByUsername(request).getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress,port);
			serverSocket.send(sendPacket);
			
			
			
			
		}
	}
	
}
