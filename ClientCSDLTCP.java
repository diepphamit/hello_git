package ThiCuoiKi;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class ClientCSDLTCP {
	public static void main(String[] args) throws IOException {
		
		InputStreamReader luongvao=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(luongvao);
		
		Socket mySocket = null;
        DataOutputStream dos = null;
        DataInputStream dis = null;
        
        try {
        	 mySocket = new Socket("localhost", 1234);
        	 dos = new DataOutputStream(mySocket.getOutputStream());
             dis = new DataInputStream(mySocket.getInputStream());
             String str = "";
             while(true){
            	 System.out.print("enter username: ");
            	 str = br.readLine();
            	 dos.writeUTF(str);
                 System.out.println(dis.readUTF());
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

