package Professor;

public class ProfessorService {
	private static ProfessorService professorService = new ProfessorService();
	private ProfessorDAO professorDAO = ProfessorDAO.getInstance();
	
	
	private ProfessorService() {}
	
	public static ProfessorService getInstance() {
		return professorService;
	}
	
	public int professor(ProfessorVO vo) {
		return professorDAO.selectProfessor(vo);
	}
	

}
