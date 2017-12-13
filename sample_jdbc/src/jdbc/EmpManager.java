package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import util.JDBCUtil;

public class EmpManager {	

	public static void printEmployee(String jobs[]) {
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int rows = 0;
		String sql = "select employee_id,first_name,salary from employees e,jobs j"
				+ " where e.job_id=j.job_id and upper(job_title) in (?,?)";
	

		try {
			con = JDBCUtil.getconnection();
			
			ps = con.prepareStatement(sql);
			ps.setString(1, jobs[0].toUpperCase());
			ps.setString(2, jobs[1].toUpperCase());
			
			rs=ps.executeQuery();	
			
			while (rs.next()) {
				System.out.print(rs.getString("EMPLOYEE_ID") + " ,");
				System.out.print(rs.getString("FIRST_NAME") + " ,");
				System.out.println(rs.getString("SALARY"));
			}			
			
		} catch (SQLException e) {
			System.out.println("sql입센션");
			System.out.println(e.getMessage());
		}catch(Exception e){
			System.out.println("입셉션");
			System.out.println(e.getMessage());
		}finally {
		
			JDBCUtil.close(rs, ps, con);
		}

	}

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(args));
		printEmployee(args);
		
	}

}
