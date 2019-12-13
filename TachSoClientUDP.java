package ThiCuoiKi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class TachSoClientUDP {
	private static final Scanner sc = new  Scanner(System.in);
	public static void main(String[] args) throws Exception{
		
		InputStreamReader luongvao=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(luongvao);
		
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("localhost");
		
		byte[] receiveData2 = new byte[1024];
		
		int m;
		while(true) {
			
			byte[] sendData = new byte[1024];
			byte[] sendData1 = new byte[1024];
			byte[] receiveData = new byte[1024];
			byte[] receiveData1 = new byte[1024];
			 try {
					System.out.print("Nhập số nguyên dương m = ");
					m = Integer.parseInt(br.readLine());
					
					if (m>0) {
						sendData = Integer.toString(m).getBytes();
						DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
						clientSocket.send(sendPacket);
						
						System.out.print("Nhập số nguyên dương m = ");
						sendData1 = Integer.toString(Integer.parseInt(br.readLine())).getBytes();
						DatagramPacket sendPacket1 = new DatagramPacket(sendData1, sendData1.length, IPAddress, 9876);
						clientSocket.send(sendPacket1);
						
						
						DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
						clientSocket.receive(receivePacket);
						String str1 = new String(receivePacket.getData());
						System.out.println(str1.trim());
						
						DatagramPacket receivePacket1 = new DatagramPacket(receiveData1, receiveData1.length);
						clientSocket.receive(receivePacket1);
						String str2 = new String(receivePacket1.getData());
						System.out.println(str2.trim());
					}
					else System.out.println("Lỗi, vui lòng nhập số nguyên dương!");
				} catch (NumberFormatException e) {
					System.out.println("Lỗi, vui lòng nhập số nguyên!");
				}
		}
		
		//clientSocket.close();
	}
}

