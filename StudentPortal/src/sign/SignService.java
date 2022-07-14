package sign;

public class SignService {
	//필드
	private static SignService signSeervice = new SignService();
	
	private SignDAO signDAO = SignDAO.getInstance();
	
	//생성자
	private SignService() {}
	
	//메소드
	public static SignService getInstance() {
		return signSeervice;
	}
	
	public int sign(SignVO vo) {
		return signDAO.selectSign(vo);
	}
	
}
