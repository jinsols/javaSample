package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBCUtil;

public class Dept_Insert {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		int rows=0;
		String sql="insert into dept values (?,?,?)";
		
		
		try {
			con =JDBCUtil.getconnection();
			System.out.println(con);
			ps=con.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(args[0]));
			ps.setString(2, args[1]);
			ps.setString(3, args[2]);
			rows=ps.executeUpdate();
			System.out.println(rows+"insert 되었습니다");			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, con);			
		}
		
		
		
		
		
		
	}
}
