package student;

import java.util.List;

import Professor.ProfessorVO;

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
			return null;
		}
	}
	public StudentVO selectOneStudent(StudentVO vo) {
		try {
			return studentDAO.selectOneStudent(vo);
		} catch (Exception e) {
			return null;
		}
	}
	public int insertStudent(StudentVO vo) {
		try {
			return studentDAO.insertStudent(vo);
		} catch (Exception e) {
			return 0;
		}
	}
	
	public int updateStudent(StudentVO vo) {
		try {
			return studentDAO.updateStudent(vo);
		}catch (Exception e) {
			return 0;
		}
	}
	public int deleteStudent(StudentVO vo) {
		try {
			return studentDAO.deleteStudent(vo);
		}catch (Exception e) {
			return 0;
		}
	}
	
	
}
