package sign;

import common.LoginMenu;
import main.Main;

public class SignService {
	//필드
	private static SignService signService = new SignService();
	private SignDAO signDAO = SignDAO.getInstance();
	//생성자
	private SignService() {}
	
	//메소드
	public static SignService getInstance() {
		return signService;
	}
	

	public int studentSign(SignVO vo) {
		try {
			return signDAO.studentSign(vo);
		}catch(Exception e) {
			return 0;
		}
	}

	public int professorSign(SignVO vo) {
		try {
			return signDAO.professorSign(vo);
		} catch(Exception e) {
			return 0;
		}
	}
	
}
