package service;

import java.util.List ;
import dao.DeptDAO;
import vo.DeptVO;

public class DeptServiceImpl implements DeptService {

	
	DeptDAO dao = new DeptDAO() ;
	
	@Override
	public List<DeptVO> getAllDeptList() {
		// TODO Auto-generated method stub
		return dao.getAllDeptList();
	}

	
	
	
}
