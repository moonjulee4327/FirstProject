package Professor;

public class ProfessorController {
	private static ProfessorController professorController = new ProfessorController();
	private ProfessorService professorService = ProfessorService.getInstance();
	
	
	private ProfessorController() {}
	
	public static ProfessorController getInstance() {
		return professorController;
	}
	
	public int professor(ProfessorVO vo) {
		return professorService.professor(vo);
	}
}
