package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBCUtil;

public class Dept_update {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Connection con = null ;
       PreparedStatement ps = null ;
       ResultSet rs = null ;
       int rows = 0 ;
       String sql = "update dept set loc = ? where deptno=?";		
	   try{
       con = JDBCUtil.getconnection() ;
       ps = con.prepareStatement(sql) ;
       ps.setString(1,  args[0]);
       ps.setString(2, args[1]);
       rows =  ps.executeUpdate();
       System.out.println(rows+"   update ����");
      
       ps = con.prepareStatement("select * from dept where deptno="+args[1]) ;
       rs = ps.executeQuery();
       if(rs.next()){
    	   System.out.println("������ ���� �����Ǿ����ϴ�.");
    	   System.out.print(rs.getString("deptno"));
    	   System.out.print(rs.getString("dname"));
    	   System.out.println(rs.getString("loc"));
       }else{
    	   System.out.println("������ row�� �����ϴ�.");
       }
       
	   } catch (SQLException e) {
		   e.printStackTrace();
	   }finally{
		   
	   }
		
	}

}
