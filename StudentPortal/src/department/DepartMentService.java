package department;

import java.util.List;

public class DepartMentService {
	//필드
	private static DepartMentService studentService = new DepartMentService();
	private DepartMentDAO departmentDAO = DepartMentDAO.getInstance();
	
	//생성자
	private DepartMentService() {}
	
	//메소드
	public static DepartMentService getInstance() {
		return studentService;
	}
	
	public List<DepartMentVO> selectDepartment() {
		
		try {
			return departmentDAO.selectDepartment();
		} catch (Exception e) {
			return null;
		}
	}
	
	public DepartMentVO selectOneDepartment(DepartMentVO vo) {
		
		try {
			return departmentDAO.selectOneDepartment(vo);
		} catch (Exception e) {
			return null;
		}
	}
	
	public int insertDepartment(DepartMentVO vo) {
		try {
			return departmentDAO.insertDepartment(vo);
		} catch (Exception e) {
			return 0;
		}
	}
	
	public int updateDepartment(DepartMentVO vo) {
		try {
			return departmentDAO.updateDepartment(vo);
		} catch (Exception e) {
			return 0;
		}
	}
	
	public int deleteDepartment(DepartMentVO vo) {
		try {
			return departmentDAO.deleteDepartment(vo);
		} catch (Exception e) {
			return 0;
		}
	}
	
	
	
}
