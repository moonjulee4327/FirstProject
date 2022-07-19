package lecture;

import java.util.List;

import sign.SignVO;
import student.StudentVO;

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
			return null;
		}
	}
	
	public LectureVO selectOneLecture(LectureVO vo) {
		try {
			return lectureDAO.selectOneLecture(vo);
		} catch (Exception e) {
			return null;
		}
	}
	
	public int LectureInsert(LectureVO vo) {
		try {
			return lectureDAO.insertLecture(vo);
		} catch (Exception e) {
			return 0;
		}
	}
	
	public List<LectureVO> audSelect() {
		try {
			return lectureDAO.audSelect();
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<LectureVO> audSelect(SignVO session) {
		try {
			return lectureDAO.audSelect(session);
		} catch (Exception e) {
			return null;
		}
	}
	
	public int audInsert(String vo, SignVO session) {
		try {
			return lectureDAO.audInsert(vo,session);
		} catch (Exception e) {
			return 0;
		}
   }

	public int updateStudent(LectureVO vo) {
		try {
			return lectureDAO.updateLecture(vo);
		} catch (Exception e) {
			return 0;
		}
	}

	public String selectOneAud(String lecNo, SignVO session) {
		try {
			return lectureDAO.selectOneAud(lecNo,session);
		} catch(Exception e) {
			return null;
		}
	}
	
	  public List<LectureVO> beforeDelete(SignVO session) {
	      try {
	         return lectureDAO.beforeAudDelete(session);
	      } catch (Exception e) {
	         return null;
	      }
	   }
	   
	   public int audDelete(LectureVO vo) {
	      try {
	         return lectureDAO.studentAudDelete(vo);
	      } catch (Exception e) {
	         return 0;
	      }
	   }
	   
	   public LectureVO audOneSelect(LectureVO vo, SignVO session) {
	      try {
	         return lectureDAO.selectOneAud(vo, session);
	      } catch (Exception e) {
	         return null;
	      }
	   }
}
