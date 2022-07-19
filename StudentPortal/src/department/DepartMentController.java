package department;

import java.util.List;

public class DepartMentController {
	//필드
	private static DepartMentController depController = new DepartMentController();
	private DepartMentService depService = DepartMentService.getInstance();
	
	//생성자
	private DepartMentController() {}
	
	//메소드
	public static DepartMentController getInstance() {
		return depController;
	}
	
	public List<DepartMentVO> selectDepartment() {
		return depService.selectDepartment();
	}
	public DepartMentVO selectOneDepartment(DepartMentVO vo) {
		return depService.selectOneDepartment(vo);
	}
	
	public int insertDepartment(DepartMentVO vo) {
		return depService.insertDepartment(vo);
	}
	
	public int updateDepartment(DepartMentVO vo) {
		return depService.updateDepartment(vo);
	}
	
	public int deleteDepartment(DepartMentVO vo) {
		return depService.deleteDepartment(vo);
	}
}
