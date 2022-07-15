package Professor;

import java.util.List;

public class ProfessorController {
	private static ProfessorController professorController = new ProfessorController();
	private ProfessorService professorService = ProfessorService.getInstance();
	
	
	private ProfessorController() {}
	
	public static ProfessorController getInstance() {
		return professorController;
	}
	
	public List<ProfessorVO> professor() {
		return professorService.professor();
	}
	public int insertProfessor(ProfessorVO vo) {
		return professorService.insertProfessor(vo);
	}
}
