package sub;

import java.util.List;

public class SubController {
	private static SubController subController = new SubController();
	private SubService subService = SubService.getInstance();

	private SubController() {
	}

	public static SubController getInstance() {
		return subController;
	}

	public List<SubVO> selectSub() {
		return subService.selectSub();
	}
	
	public int insertSub(SubVO vo)   {
		return subService.insertSub(vo);
	}

}
