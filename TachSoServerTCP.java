package ThiCuoiKi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class TachSoServerTCP {
	private ServerSocket serverSocket;
	
	public TachSoServerTCP(int port) {
		try {
		      //System.out.println(port);
		      serverSocket = new ServerSocket(port);
		      while (true) {
		        Socket clientSocket = serverSocket.accept();
		        //System.out.println(clientSocket.isConnected());
		        if (clientSocket.isConnected()) {
		          ClientConnection connectionThread 
		 					= new ClientConnection(clientSocket);
		          connectionThread.start();
		        }
		      }
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
	}
	public static void main(String[] args) {
		new TachSoServerTCP(1234);

	}

}

class ClientConnection extends Thread {
	private Socket clientSocket;
    private static int connectionCount;
    private DataInputStream dis;
    private DataOutputStream dos;
    
	 public ClientConnection(Socket clienSocket) {
		this.clientSocket = clienSocket;
		this.connectionCount++;
	 }
	 
	 public void run() {
		 try {
		        dis = new DataInputStream(clientSocket.getInputStream());
		        dos = new DataOutputStream(clientSocket.getOutputStream());
		        //String day = new Date().toString();
		        int data;
		        
		        while ((data=dis.readInt()) > 0) {
	        		dos.writeUTF(new XulyTinToan().TachChuoi(data));	
		         }
		      } catch (Exception e) {
		        e.printStackTrace();
		      }
	 }
	 
}
class XulyTinToan {
	public XulyTinToan() {
		
	}
	public String TachChuoi(int m) {
		String SForReturn = "";
		while(m>0) {
			SForReturn += m%10;
			if(m>=10) SForReturn+=" , "; 
			m = m/10;
		}
		return SForReturn;
	}
}

