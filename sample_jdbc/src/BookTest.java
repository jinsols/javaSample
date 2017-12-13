 

public class BookTest {

	public static void main(String[] args) {
	 int inx = 5;
	 int result = 0 ;
	 
	 switch(inx){
	 case 5:
		 result += inx ;
	 case 10 :
		 result += ++inx ;
	 case 15:
		 result +=inx++ ;
		 break;
	 case 20:
		 ++result ;
		 break ;
    default :
	 }
	 System.out.println(result);
	}

}
