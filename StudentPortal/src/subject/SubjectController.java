package subject;

import java.util.List;

import Professor.ProfessorVO;

public class SubjectController {
	private static SubjectController subController = new SubjectController();
	private SubjectService subService = SubjectService.getInstance();

	private SubjectController() {
	}

	public static SubjectController getInstance() {
		return subController;
	}

	public List<SubjectVO> selectSub() {
		return subService.selectSub();
	}
	
	public SubjectVO selectOneSub(SubjectVO vo) {
		return subService.selectOneSub(vo);
	}
	public int updateSub(SubjectVO vo) {
		return subService.updateSub(vo);
	}
	public int insertSub(SubjectVO vo)   {
		return subService.insertSub(vo);
	}

	

}
