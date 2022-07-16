package rc;

import java.util.List;

import sign.SignVO;

public class RcService {
	private static RcService rcService = new RcService();
	private RcDAO rcDAO = RcDAO.getInstance();

	private RcService() {
	}

	public static RcService getInstance() {
		return rcService;
	}

	public List<RcVO> selectSub(SignVO vo) {	//강의목록
		try {
			return rcDAO.selectSub(vo);
		} catch (Exception e) {
//			e.printStackTrace();
			return null;
		}
	}

	public List<RcVO> selectStu(int lecNo) {	// 학생목록(수강번호)
		try {
			return rcDAO.selectStu(lecNo);
		} catch (Exception e) {
//			e.printStackTrace();
			return null;
		}
	}
	
	public int updateRc(RcVO vo) {
		
		try {
			return rcDAO.updateRc(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return 0;
	}
	
	public List<RcVO> rcStudentSelect(SignVO session) {	
		try {
			return rcDAO.rcStudentSelect(session);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	

}
