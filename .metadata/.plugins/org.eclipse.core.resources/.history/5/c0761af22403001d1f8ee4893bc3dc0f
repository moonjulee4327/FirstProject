package student;

public class StudentService {
	//필드
	private static StudentService studentService = new StudentService();
	private StudentDAO studentDAO = StudentDAO.getInstance();
	
	//생성자
	private StudentService() {}
	
	//메소드
	public static StudentService getInstance() {
		return studentService;
	}
	
	public int select(StudentVO vo) {
		return studentDAO.select(vo);
	}
	
}
