package lecture;

import java.util.List;

import main.Main;
import sign.SignVO;
import student.StudentVO;

public class LectureController {
	//필드
	private static SignVO session = Main.getSession();
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
	public LectureVO selectOneLecture(LectureVO vo) {
		return lectureService.selectOneLecture(vo);
	}
	
	public int LectureInsert(LectureVO vo) {
		return lectureService.LectureInsert(vo);
	}
	
	public List<LectureVO> audSelect() {
		return lectureService.audSelect();	
	}
	public List<LectureVO> audSelectSession() {
		return lectureService.audSelect(session);	
	}	
    public LectureVO audSelectOneSession(LectureVO vo) {
	      return lectureService.audOneSelect(vo, session);   
    }
	public int audInsert(String vo) {
		return lectureService.audInsert(vo, session);
	}   
	
	public int updateLecture(LectureVO vo) {
		return lectureService.updateStudent(vo);
	}

	public String selectOneAud(String lecNo) {
		return lectureService.selectOneAud(lecNo,session);
		
	}
	  public List<LectureVO> beforeDelete() {
	      return lectureService.beforeDelete(session);
	   }
	   
	   public int audDelete(LectureVO vo) {
	      return lectureService.audDelete(vo);
	   }
}
