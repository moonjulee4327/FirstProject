package Professor;

import java.util.List;

public class ProfessorController {
	private static ProfessorController professorController = new ProfessorController();
	private ProfessorService professorService = ProfessorService.getInstance();
	
	
	private ProfessorController() {}
	
	public static ProfessorController getInstance() {
		return professorController;
	}
	
	public List<ProfessorVO> selectProfessor() {
		return professorService.professor();
	}
	public ProfessorVO selectOneProfessor(ProfessorVO vo) {
		return professorService.OneProfessor(vo);
	}
	public int insertProfessor(ProfessorVO vo) {
		return professorService.insertProfessor(vo);
	}
	public int updateProfessor(ProfessorVO vo) {
		return professorService.updateProfessor(vo);
	}
	public int deleteProfessor(ProfessorVO vo) {
		return professorService.deleteProfessor(vo);
	}
}
