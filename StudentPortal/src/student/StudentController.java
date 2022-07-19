package student;

import java.util.List;

import Professor.ProfessorVO;

public class StudentController {
	//필드
	private static StudentController studentController = new StudentController();
	private StudentService studentService = StudentService.getInstance();
	
	//생성자
	private StudentController() {}
	
	//메소드
	public static StudentController getInstance() {
		return studentController;
	}
	
	public List<StudentVO> selectStudent() {
		return studentService.selectStudent();
	}
	public StudentVO selectOneStudent(StudentVO vo) {
		return studentService.selectOneStudent(vo);
	}
	public int insertStudent(StudentVO vo) {
		return studentService.insertStudent(vo);
	}
	public int updateStudent(StudentVO vo) {
		return studentService.updateStudent(vo);
	}
	public int deleteStudent(StudentVO vo) {
		return studentService.deleteStudent(vo);
	}
}
