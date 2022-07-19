package subject;

import java.util.List;

import Professor.ProfessorVO;

public class SubjectService {
	private static SubjectService subService = new SubjectService();
	private SubjectDAO subDAO = SubjectDAO.getInstance();
	
	private SubjectService() {}
	
	public static SubjectService getInstance() {
		return subService;
	}
	
	public List<SubjectVO> selectSub() {
		try {
			return subDAO.selectSub();
		} catch (Exception e) {
			return null;
		}
	}
	
	public SubjectVO selectOneSub(SubjectVO vo) {
		try {
			return subDAO.selectOneSub(vo);
		} catch (Exception e) {
			return null;
		}
	}
	
	public int insertSub(SubjectVO vo)   {
		try {
			return subDAO.insertSub(vo);
		} catch (Exception e) {
		}
		return 0;
	}
	public int updateSub( SubjectVO vo) {
		try {
			return subDAO.updateSub(vo);
		} catch (Exception e) {
			return 0;
		}
	}
}
