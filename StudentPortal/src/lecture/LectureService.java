package lecture;

import java.util.List;

public class LectureService {
	//필드
	private static LectureService lectureService = new LectureService();
	private LectureDAO lectureDAO = LectureDAO.getInstance();
	//생성자
	private LectureService() {}
	
	//메소드
	public static LectureService getInstance() {
		return lectureService;
	}
	public List<LectureVO> selectLecture() {
		try {
			return lectureDAO.selectLecture();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
