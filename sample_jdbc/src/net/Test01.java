package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address.getHostAddress());
			System.out.println(address.getHostName());
			address = InetAddress.getByName("www.naverR3.com") ;
			System.out.println("naver : "+address.getHostAddress());
			System.out.println();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("주소를 확인해 주세요");
		}
		
		System.out.println("Main End");
	}

}
