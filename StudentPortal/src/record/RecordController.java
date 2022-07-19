package record;

import java.util.List;

import main.Main;
import sign.SignVO;

public class RecordController {
	private static SignVO session = Main.getSession();
	private static RecordController instance = new RecordController();
	private RecordService recordService = RecordService.getInstance();

	private RecordController() {
	}

	public static RecordController getInstance() {
		return instance;
	}
	
	public List<RecordVO> selectStu(String lecNo) {
		return recordService.selectStu(lecNo, session);
	}
	public List<RecordVO> selectSub() {
		return recordService.selectSub(session);
	}
	
	public int insertRecord(String audNo) {
		return recordService.insertRecord(audNo);
	}
	
	public int updateRc(RecordVO vo) {
		return recordService.updateRc(vo);
	}
	
	public List<RecordVO> rcStudentSelect() {
		return recordService.rcStudentSelect(session);
	
}

	public int deleteRecord(String audNo) {
		return recordService.deleteRecord(audNo);
	}
}
