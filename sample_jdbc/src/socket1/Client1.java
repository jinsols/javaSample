package socket1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Socket socket = null ;
          
          try {
			 socket= new Socket("70.12.109.74", 9000);
			 System.out.println("Á¢¼ÓµÊ");
		     InputStream in = socket.getInputStream() ;
		     BufferedReader br = new BufferedReader(new InputStreamReader(in)) ;
			 System.out.println(br.readLine());
		      
              
			 
			 
 		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(socket != null ) socket.close();
				 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
