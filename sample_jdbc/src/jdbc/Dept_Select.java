package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import util.JDBCUtil;
import vo.DeptVO;

public class Dept_Select {

	public static void main(String[] args) {
	 
		Connection con = null ;
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		int rows = 0 ;
		String sql = "SELECT * FROM DEPT ORDER BY DEPTNO";
        List<DeptVO> list = new ArrayList<DeptVO>() ;
		
		con = JDBCUtil.getconnection() ;
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery() ;
			while(rs.next()){
		//rs�� �ִ� row data�� �ڹ� DeptVO ��üȭ�ؼ� list�� ���
		     DeptVO rowdata = new DeptVO(rs.getInt("deptno"),
		    		                     rs.getString("dname"),
		    		                     rs.getString("loc"));

		       list.add(rowdata) ;
			}
		} catch (SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, con);
		}
		
		
		Iterator<DeptVO> it = list.iterator() ;
		while(it.hasNext()) {
			DeptVO data = (DeptVO) it.next();
			System.out.println(data);
		}
		
		try{
			while(rs.next()){
				System.out.print(rs.getString("deptno"));
				System.out.print(rs.getString("dname"));
				System.out.println(rs.getString("dloc"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, con);
		}
	}

}
