package Professor;

import java.util.List;

public class ProfessorService {
	private static ProfessorService professorService = new ProfessorService();
	private ProfessorDAO professorDAO = ProfessorDAO.getInstance();
	
	//세션 getInstance
	private ProfessorService() {}
	
	public static ProfessorService getInstance() {
		return professorService;
	}
	
	public List<ProfessorVO> professor() {
		try {
			return professorDAO.selectProfessor();
		} catch (Exception e) {
			return null;
		}
	}
	
	public ProfessorVO OneProfessor(ProfessorVO vo) {
		try {
			return professorDAO.selectOneProfessor(vo);
		} catch (Exception e) {
			return null;
		}
	}
	public int insertProfessor(ProfessorVO vo) {
		try {
		return professorDAO.insertProfessor(vo);
		}catch (Exception e) {
			return 0;
		}
	}
	public int updateProfessor(ProfessorVO vo) {
		try {
			return professorDAO.updateProfessor(vo);
		}catch (Exception e) {
			return 0;
		}
	}
	public int deleteProfessor(ProfessorVO vo) {
		try {
			return professorDAO.deleteProfessor(vo);
		}catch (Exception e) {
			return 0;
		}
	}
	

}
