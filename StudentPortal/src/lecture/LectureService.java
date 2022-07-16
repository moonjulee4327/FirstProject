package lecture;

import java.util.List;

import sign.SignVO;

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
	
	public int LectureInsert(LectureVO vo) {
		try {
			return lectureDAO.insertLecture(vo);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public List<LectureVO> audSelect() {
		try {
			return lectureDAO.audSelect();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int audInsert(String vo, SignVO session) {
		try {
			return lectureDAO.audInsert(vo,session);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public List<LectureVO> audSelect(SignVO session) {
	      try {
	         return lectureDAO.audSelect(session);
	      } catch (Exception e) {
	         return null;
	      }
	   }
	
}
