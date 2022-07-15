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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public int insertProfessor(ProfessorVO vo) {
		try {
		return professorDAO.insertProfessor(vo);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	

}
