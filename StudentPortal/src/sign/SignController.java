package sign;

public class SignController {
	private static SignController signController = new SignController();
	private SignService signService = SignService.getInstance();
	
	private SignController() {}
	
	public static SignController getInstance() {
		return signController;
	}
	
	public int sign(SignVO vo) {
		return signService.sign(vo);
	}
}
