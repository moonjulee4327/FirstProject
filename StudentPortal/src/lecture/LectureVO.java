package lecture;

public class LectureVO {
	//필드
	private String lecNo;
	private String lecSub;
	private String lecDep;
	private String yr;
	private String sem;
	private String lecTm;
	private String lecWk;
	//쿼리로 인한 증가
	private String proNm;
	private String rmNm;
	private String countAdu;
	
	//생성자
	public LectureVO() {}
	
	public LectureVO(String lecNo, String lecSub) {
		this.lecNo = lecNo;
		this.lecSub = lecSub;
	}
		
	public LectureVO(String lecNo, String yr, String sem, String lecSub, String lecDep, String lecTm, String lecWk) {
		this.lecNo = lecNo;
		this.lecSub = lecSub;
		this.lecDep = lecDep;
		this.yr = yr;
		this.sem = sem;
		this.lecTm = lecTm;
		this.lecWk = lecWk;
	}
	
	public LectureVO(String lecNo, String lecSub, String lecDep, String proNm, String yr, String sem, String lecTm, String lecWk,
			 String rmNm, String countAdu) {
		this.lecNo = lecNo;
		this.lecSub = lecSub;
		this.lecDep = lecDep;
		this.yr = yr;
		this.sem = sem;
		this.lecTm = lecTm;
		this.lecWk = lecWk;
		this.proNm = proNm;
		this.rmNm = rmNm;
		this.countAdu = countAdu;
	}

	
	//메소드
	public String getLecNo() {
		return lecNo;
	}

	public void setLecNo(String lecNo) {
		this.lecNo = lecNo;
	}

	public String getLecSub() {
		return lecSub;
	}

	public void setLecSub(String lecSub) {
		this.lecSub = lecSub;
	}

	public String getLecDep() {
		return lecDep;
	}

	public void setLecDep(String lecDep) {
		this.lecDep = lecDep;
	}

	public String getYr() {
		return yr;
	}

	public void setYr(String yr) {
		this.yr = yr;
	}

	public String getSem() {
		return sem;
	}

	public void setSem(String sem) {
		this.sem = sem;
	}

	public String getLecTm() {
		return lecTm;
	}

	public void setLecTm(String lecTm) {
		this.lecTm = lecTm;
	}

	public String getLecWk() {
		return lecWk;
	}

	public void setLecWk(String lecWk) {
		this.lecWk = lecWk;
	}

	
	public String lectureString() {
		return String.format("%s \t %s \t %s \t %s \t %s \t %s \t %s \t", lecNo, lecSub, lecDep, yr, sem, lecTm, lecWk);
	}
	
	public String audString() {
		return String.format("%s \t %s \t %s \t %s \t %s \t %s \t %s \t %s \t %s \t %s \t", lecNo, lecSub, lecDep, yr, sem, lecTm, lecWk, proNm, rmNm, countAdu);
	}


	
}
