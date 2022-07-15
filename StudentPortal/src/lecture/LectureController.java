package lecture;

import java.util.List;

public class LectureController {
	//필드
	private static LectureController lectureController = new LectureController();
	private LectureService lectureService = LectureService.getInstance();
	
	//생성자
	private LectureController() {}
	
	//메소드
	public static LectureController getInstance() {
		return lectureController;
	}
	
	public List<LectureVO> selectLecture() {
		return lectureService.selectLecture();
	}
	
	public int LectureInsert(LectureVO vo) {
		return lectureService.LectureInsert(vo);
	}
	public List<LectureVO> audSelect() {
		return lectureService.audSelect();	
	}	
	public int audInsert(LectureVO vo) {
		return lectureService.audInsert(vo);
	}	
		
}
