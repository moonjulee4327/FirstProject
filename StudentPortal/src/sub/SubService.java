package sub;

import java.util.List;

public class SubService {
	private static SubService subService = new SubService();
	private SubDAO subDAO = SubDAO.getInstance();
	
	private SubService() {}
	
	public static SubService getInstance() {
		return subService;
	}
	
	public List<SubVO> selectSub() {
		try {
			return subDAO.selectSub();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int insertSub(SubVO vo)   {
		try {
			return subDAO.insertSub(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
