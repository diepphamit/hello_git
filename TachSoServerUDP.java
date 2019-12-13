package ThiCuoiKi;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class TachSoServerUDP {
	public static void main(String[] args) throws Exception{
		DatagramSocket serverSocket = new DatagramSocket(9876);
		System.out.println("Server is started");
		
		
		while(true) {
			byte[] receiveData = new byte[1024];
			byte[] receiveData1 = new byte[1024];
			byte[] sendData = new byte[1024];
			byte[] sendData1 = new byte[1024];
			//create empty packet to receive data from client
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			
			DatagramPacket receivePacket1 = new DatagramPacket(receiveData1, receiveData1.length);
			serverSocket.receive(receivePacket1);
			
			InetAddress IPAddress = receivePacket.getAddress();
			
			int port = receivePacket.getPort();
			
			String request = new String(receivePacket.getData());
			String request1 = new String(receivePacket1.getData());
	
			sendData = new TachSoServerUDP().reverseString(request).getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress,port);
			serverSocket.send(sendPacket);
			
			sendData1 = new TachSoServerUDP().convertString(request1).getBytes();
			DatagramPacket sendPacket1 = new DatagramPacket(sendData1, sendData1.length, IPAddress,port);
			serverSocket.send(sendPacket1);

			
			
		}
	}
	
	public String reverseString(String s) {
		s = s.trim();
		String sForReturn = "";
		int number = Integer.parseInt(s);
		while(number>0) {
			sForReturn += number%10;
			number/=10;
			if(number>0) sForReturn += " , ";
		}
		return sForReturn;
	}
	
	public String convertString(String s) {
		String sForReturn = "";
		String sTemp = reverseString(s);
		for(int i=sTemp.length()-1;i>=0;i--) {
			sForReturn += sTemp.charAt(i);
		}
		return sForReturn;
	}
}


