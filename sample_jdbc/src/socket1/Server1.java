package socket1;

import java.io.BufferedWriter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.omg.CORBA.portable.InputStream;

public class Server1 {

	public static void main(String[] args) {
		ServerSocket server = null ;
		Socket socket = null ;
	  try {
		server = new ServerSocket(9000) ;
		System.out.println("Server : ���Ӵ����....");
	     socket =  server.accept();
	     System.out.println(socket.getInetAddress()+" ������");
	     
	     OutputStream out = socket.getOutputStream() ;
	     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out)) ;
	     
	     bw.write("������ ȯ���մϴ�....");
	     bw.flush();
	     
	          
	     InputStream in = socket.getInputStream() ;
	     Bufferedreader
	     
	  } catch (IOException e) {
 
		e.printStackTrace();
	} finally{
		try {
			if(socket != null ) socket.close();
			if(server != null) server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
                
	}

}
