package ThiCuoiKi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientCSDLUDP {
	private static final Scanner sc = new  Scanner(System.in);
	public static void main(String[] args) throws Exception{
		
		InputStreamReader luongvao=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(luongvao);
		
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("localhost");
		
		
		int m;
		while(true) {
			byte[] sendData = new byte[1024];
			byte[] receiveData = new byte[1024];
			System.out.print("Enter username: ");
			sendData = br.readLine().getBytes();
			
	
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
			clientSocket.send(sendPacket);
			
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			clientSocket.receive(receivePacket);
			String str = new String(receivePacket.getData());
			System.out.println(str.trim());
					
				
		}
		
		//clientSocket.close();
	}
}
