package student;

import java.util.List;

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
	
	public List<StudentVO> selectStudent() {
		
		try {
			return studentDAO.selectStudent();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int insertStudent(StudentVO vo) {
		try {
			return studentDAO.insertStudent(vo);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
	
}
