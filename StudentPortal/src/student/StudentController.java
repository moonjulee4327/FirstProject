package student;

import java.util.List;

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
	
	public int insertStudent(StudentVO vo) {
		return studentService.insertStudent(vo);
	}
}
