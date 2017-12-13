package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         try {
			URL url = new URL("https://www.naver.com/index.html") ;
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		    String readLine = null ;
            while((readLine = br.readLine()) != null ){
            	System.out.println(readLine);
            }
            br.close();
         } catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
         System.out.println("main end");
         
	}

}
