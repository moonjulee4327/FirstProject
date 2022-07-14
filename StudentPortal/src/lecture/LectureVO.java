package lecture;

public class LectureVO {
	//필드
	private int lecNo;
	private String lecSub;
	private String lecDep;
	private String yr;
	private int sem;
	private String lecTm;
	private String lecWk;
	
	//생성자
	public LectureVO() {}
	
	public LectureVO(int lecNo, String yr, int sem, String lecSub, String lecDep, String lecTm, String lecWk) {
		this.lecNo = lecNo;
		this.lecSub = lecSub;
		this.lecDep = lecDep;
		this.yr = yr;
		this.sem = sem;
		this.lecTm = lecTm;
		this.lecWk = lecWk;
	}
	
	//메소드
	public int getLecNo() {
		return lecNo;
	}

	public void setLecNo(int lecNo) {
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

	public int getSem() {
		return sem;
	}

	public void setSem(int sem) {
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

	@Override
	public String toString() {
		return String.format("%s \t %s \t %s \t %s \t %s \t %s \t %s \t", lecNo, lecSub, lecDep, yr, sem, lecTm, lecWk);
	}
	
	
	
}
