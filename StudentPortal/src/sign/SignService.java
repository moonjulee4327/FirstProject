package sign;

import common.LoginMenu;
import main.Main;

public class SignService {
	//필드
	private static SignService signService = new SignService();
	private SignDAO signDAO = SignDAO.getInstance();
	private SignVO admin = new SignVO("java","java");
	private SignVO session = Main.getSession();
	static final int STUDENT_NO_LENGTH = 9;
	static final int PROFESSOR_NO_LENGTH = 7;
	static final int ADMIN_NO_LENGTH = 4;
	//생성자
	private SignService() {}
	
	//메소드
	public static SignService getInstance() {
		return signService;
	}
	
	public int sign(SignVO vo) {
		int length = vo.getId().length();
		int result = 0;
		switch(length){
			case STUDENT_NO_LENGTH:
				if(signDAO.studentSign(vo) == 1) {
					result = LoginMenu.STUDENT.getMenu();
					session.setId(vo.getId());
				}
				break;
			case PROFESSOR_NO_LENGTH:
				if(signDAO.professorSign(vo) == 1) {
					result = LoginMenu.PROFESSOR.getMenu();
					session.setId(vo.getId());
				}
				break;
			case ADMIN_NO_LENGTH:
				if(admin.getId().equals(vo.getId())
						&& admin.getPw().equals(vo.getPw())){
					result = LoginMenu.ADMIN.getMenu();
					session.setId(vo.getId());
				}
				break;
			default:
				break;
		}
		return result;
		
	}
	
}
