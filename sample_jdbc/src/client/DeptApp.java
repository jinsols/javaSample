package client;

import java.util.List;
import java.util.Iterator;

import service.DeptService;
import service.DeptServiceImpl;
import vo.DeptVO;

public class DeptApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        DeptService service = new DeptServiceImpl() ;
        
	//	System.out.println(service.getAllDeptList());
		List<DeptVO> list = service.getAllDeptList();
		Iterator<DeptVO> it = list.iterator() ;
		System.out.println("********DePT LIST*********");
		while (it.hasNext()){
			DeptVO data = (DeptVO) it.next();
			System.out.println(data);
			System.out.println("------------------------");
		}
	}

}
