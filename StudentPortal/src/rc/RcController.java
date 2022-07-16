package rc;

import java.util.List;

import main.Main;
import sign.SignVO;

public class RcController {
	private static SignVO session = Main.getSession();
	private static RcController rcController = new RcController();
	private RcService rcService = RcService.getInstance();

	private RcController() {
	}

	public static RcController getInstance() {
		return rcController;
	}
	
	public List<RcVO> selectStu(int lecNo) {
		return rcService.selectStu(lecNo);
	}
	public List<RcVO> selectSub() {
		return rcService.selectSub(session);
	}
	
	public int updateRc(RcVO vo) {
		return rcService.updateRc(vo);
	}
	
	public List<RcVO> rcStudentSelect() {
			return rcService.rcStudentSelect(session);
		
	}
}
