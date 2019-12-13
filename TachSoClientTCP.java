package ThiCuoiKi;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class TachSoClientTCP {
	private static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		Socket mySocket = null;
        DataOutputStream dos = null;
        DataInputStream dis = null;
        InputStreamReader luongvao=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(luongvao);
        try {
        	 mySocket = new Socket("localhost", 1234);
        	 dos = new DataOutputStream(mySocket.getOutputStream());
             dis = new DataInputStream(mySocket.getInputStream());
             //String str = "";
             int m = 0;
             while(true){
            	 //Nhap so
            	 try {
 					System.out.print("Nhập số nguyên dương m = ");
 					m = Integer.parseInt(br.readLine());;
 					
 					if (m>0) {
 						dos.writeInt(m);
 						System.out.println(dis.readUTF());
 					}
 					else System.out.println("Lỗi, vui lòng nhập số nguyên dương!");
 				} catch (NumberFormatException e) {
 					System.out.println("Lỗi, vui lòng nhập số nguyên!");
 				}
            	 
// 					System.out.print("enter string ");
// 					str = br.readLine().toString();
             }
             
 			
 			
        }
        catch(Exception e) {
            System.out.print("Ngat ket noi");
            dis.close();
            dos.close();
            mySocket.close();
            e.printStackTrace();

        }
	}
}

