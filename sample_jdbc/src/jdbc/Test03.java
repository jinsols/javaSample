package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test03 {
	public static void main(String[] args) {

		Connection con = null; // ���� ��ü db
		Statement st = null; // sql���� ������ü
		PreparedStatement ps = null; // ������Ʈ��Ʈ �ڽ� ���� �̰ž���
		ResultSet rs = null; // select ���ϰ� resulset
		
		int rows = 0;
		
		

		//String sql = "select * from emp where deptno= "+args[0];
				
		String sql = "select * from emp where upper(ename) like ?";//ps ����� �̷��� �����ִ�.
		

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user = "scott";
			String pw = "tiger";
			con = DriverManager.getConnection(url, user, pw);
			System.out.println(con);
			//st = con.createStatement();
			
			ps=con.prepareStatement(sql);
			ps.setString(1, '%'+args[0].toUpperCase()+'%'); //�Ʊ��� �ϳ� �������� ����ǥ
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getString("empno") + " ,");
				System.out.print(rs.getString("ename")+ " ,");
				System.out.print(rs.getString("job") + " ,");
				System.out.print(rs.getString("mgr")+ " ,");
				System.out.print(rs.getDate("hiredate") + " ,");
				System.out.print(rs.getInt("sal")+ " ,");
				System.out.print(rs.getInt("comm") + " ,");
				System.out.println(rs.getString("deptno"));
				//System.out.println();
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println("main end");
	}
}
