package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBCUtil;

public class Dept_Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int rows = 0;
		String sql = "delete from dept where deptno? ";

	    con = JDBCUtil.getconnection() ;
	    try{
	    ps = con.prepareStatement(sql) ;
	    ps.setString(1, args[0]);
	    rows = ps.executeUpdate();
	    System.out.println(rows+" delete");
	    
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }finally{
	    	JDBCUtil.close(rs,ps,con) ;
	    }
	
	}

}
