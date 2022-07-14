package student;

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
	
	public int select(StudentVO vo) {
		return studentService.select(vo);
	}
	
}
