package sign;

public class SignService {
	//필드
	private static SignService signSeervice = new SignService();
	private SignDAO signDAO = SignDAO.getInstance();
	private SignVO admin = new SignVO("java","java");
	//생성자
	private SignService() {}
	
	//메소드
	public static SignService getInstance() {
		return signSeervice;
	}
	
	public int sign(SignVO vo) {
		int length = vo.getId().length();
		switch(length){
			case 9:
				return signDAO.studentSign(vo);
			case 7:
				return signDAO.professorSign(vo);
			default:
				if(admin.getId().equals(vo.getId())
						&& admin.getPw().equals(vo.getPw())){
					return 3;
				}
				return 0;
		}
		
	}
	
}
