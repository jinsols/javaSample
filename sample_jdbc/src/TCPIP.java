package socket3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoServer {
	public static void main(String args[]) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(9001);
			System.out.println("클라이언트의 접속을 대기중");
			while (true) {
				Socket socket = server.accept();
				new EchoThread(socket).start();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(server != null)server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}

class EchoThread extends Thread {
	Socket socket;

	public EchoThread() {	}
	public EchoThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		InetAddress address = socket.getInetAddress();
		System.out.println(address.getHostAddress() + " 로부터 접속했습니다.");
		try {
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));

			String message = null;
			while ((message = br.readLine()) != null) {
				System.out.println("클라이언트 --> 서버로 : " + message);
				pw.println(message);
				pw.flush();
			}
			br.close();
			pw.close();
			socket.close();

		} catch (Exception e) {

		} finally {

		}
	}
}
public class Client1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Socket socket = null ;
          
          try {
        	 String name = args[0] ;
			 socket= new Socket("70.12.109.74", 9000);
			 System.out.println("접속됨");
			 BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)) ;
		     InputStream in = socket.getInputStream() ;
		     BufferedReader br = new BufferedReader(new InputStreamReader(in)) ;
			 OutputStream out =  socket.getOutputStream();
			 PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
              
			 String message = null ;
			 while((message = keyboard.readLine())!=null){
				 if(message.equals("종료")) break ;
				 pw.print(args[0] + ":"+message);
				 pw.flush();
				 System.out.println("서버-> 클라이언트로 : "+message);
			 }
			 br.close();
			 pw.close();
			 socket.close();
			 
 		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 
			}
		}
	}

 
