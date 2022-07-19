package sign;

import common.LoginMenu;
import main.Main;

public class SignController {
	private static SignController signController = new SignController();
	private SignService signService = SignService.getInstance();
	private SignVO session = Main.getSession();
	private SignVO admin = new SignVO("java","java");
	static final int STUDENT_NO_LENGTH = 9;
	static final int PROFESSOR_NO_LENGTH = 7;
	static final int ADMIN_NO_LENGTH = 4;
	private SignController() {}
	
	public static SignController getInstance() {
		return signController;
	}
	
	public int sign(SignVO vo) {
		int length = vo.getId().length();
		int result = 0;
		switch(length){
			case STUDENT_NO_LENGTH:
				if(signService.studentSign(vo) == 1) {
					result = LoginMenu.STUDENT.getMenu();
					session.setId(vo.getId());
				}
				break;
			case PROFESSOR_NO_LENGTH:
				if(signService.professorSign(vo) == 1) {
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
