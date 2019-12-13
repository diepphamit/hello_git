package ThiCuoiKi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class ServerCSDLTCP {
	private ServerSocket serverSocket;
	
	public ServerCSDLTCP(int port) {
		try {
		      //System.out.println(port);
		      serverSocket = new ServerSocket(port);
		      while (true) {
		        Socket clientSocket = serverSocket.accept();
		        //System.out.println(clientSocket.isConnected());
		        if (clientSocket.isConnected()) {
		          ClientConnection1 connectionThread 
		 					= new ClientConnection1(clientSocket);
		          connectionThread.start();
		        }
		      }
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
	}
	public static void main(String[] args) {
		new ServerCSDLTCP(1234);

	}

}

class ClientConnection1 extends Thread {
	private Socket clientSocket;
    private static int connectionCount;
    private DataInputStream dis;
    private DataOutputStream dos;
    private KetNoiCSDL csdl;
	 public ClientConnection1(Socket clienSocket) {
		this.clientSocket = clienSocket;
		this.connectionCount++;
		csdl = new KetNoiCSDL();
	 }
	 
	 public void run() {
		 try {
		        dis = new DataInputStream(clientSocket.getInputStream());
		        dos = new DataOutputStream(clientSocket.getOutputStream());
		        //String day = new Date().toString();
		        String data;
		        while ((data = dis.readUTF()) != null) {
		        	dos.writeUTF(csdl.displayUserByUsername(data));
		         }
		      } catch (Exception e) {
		        e.printStackTrace();
		      }
	 }
	 
}

