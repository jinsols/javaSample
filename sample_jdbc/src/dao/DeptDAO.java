package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.DeptVO;

public class DeptDAO {
Connection con ;
PreparedStatement ps ;
ResultSet rs ;


public List<DeptVO> getAllDeptList() {
	String sql = "select * from dept order by deptno" ;	
	List<DeptVO> list = new ArrayList<>() ;
	con = JDBCUtil.getconnection() ;
	try{
		ps = con.prepareStatement(sql);
	    rs= ps.executeQuery();
	    while(rs.next()){
	    	DeptVO vo = new DeptVO(rs.getInt("deptno"),
	    			               rs.getString("dname"),
	    			               rs.getString("loc")) ;
	    	list.add(vo) ;
	    }
	
	} catch (SQLException e) {
		e.printStackTrace() ;
	}finally {
		JDBCUtil.close(rs, ps, con);
	}
	return list ;
}
	
}
