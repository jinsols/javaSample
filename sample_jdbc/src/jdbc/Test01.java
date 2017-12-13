package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test01 {
	public static void main(String[] args) {

		Connection con = null; // 연결 객체 db
		Statement st = null; // sql구문 관리객체
		PreparedStatement ps = null; // 스테이트먼트 자식 거의 이거쓴다
		ResultSet rs = null; // select 리턴값 resulset

		int rows = 0;

		String sql = "select dname,loc from dept";

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user = "scott";
			String pw = "tiger";
			con = DriverManager.getConnection(url, user, pw);
			// System.out.println(con);
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getString("dname") + " ,");
				System.out.println(rs.getString("loc"));
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
