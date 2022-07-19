package lecture;

import java.util.ArrayList;
import java.util.List;

public class LectureVO {
	//필드
	private String lecNo;
	private String lecSub;
	private String subNm;
	private String lecDep;
	private String depNm;
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
	public LectureVO(String lecNo) {
		this.lecNo = lecNo;
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
	
	public LectureVO(String lecNo, String yr, String sem,String subNm, String lecSub, String depNm,String lecDep, String lecTm, String lecWk) {
		this.lecNo = lecNo;
		this.subNm = subNm;
		this.lecSub = lecSub;
		this.lecDep = lecDep;
		this.depNm = depNm;
		this.yr = yr;
		this.sem = sem;
		this.lecTm = lecTm;
		this.lecWk = lecWk;
	}
	
	
	
	public LectureVO(String lecNo, String yr, String sem, String lecSub, String depNm,String lecDep, String lecTm, String lecWk) {
		this.lecNo = lecNo;
		this.lecSub = lecSub;
		this.lecDep = lecDep;
		this.depNm = depNm;
		this.yr = yr;
		this.sem = sem;
		this.lecTm = lecTm;
		this.lecWk = lecWk;
	}
	
	public LectureVO(String lecNo,String subNm, String depNm,  String proNm, String yr, String sem, String lecTm, String lecWk,
			 String rmNm, String countAdu) {
		this.lecNo = lecNo;
		this.subNm = subNm;
		this.depNm = depNm;
		this.yr = yr;
		this.sem = sem;
		this.lecTm = lecTm;
		this.lecWk = lecWk;
		this.proNm = proNm;
		this.rmNm = rmNm;
		this.countAdu = countAdu;
	}
	public LectureVO(String lecNo,String subNm, String lecSub,String depNm, String lecDep, String proNm, String yr, String sem, String lecTm, String lecWk,
			 String rmNm, String countAdu) {
		this.lecNo = lecNo;
		this.subNm = subNm;
		this.lecSub = lecSub;
		this.depNm = depNm;
		this.lecDep = lecDep;
		this.yr = yr;
		this.sem = sem;
		this.lecTm = lecTm;
		this.lecWk = lecWk;
		this.proNm = proNm;
		this.rmNm = rmNm;
		this.countAdu = countAdu;
	}

	public LectureVO(String lecNo, List<String> list) {
		this.lecNo = lecNo;
		this.yr = list.get(0);
		this.sem = list.get(1);
		this.lecSub = list.get(2);
		this.lecDep = list.get(3);
		this.lecTm = list.get(4);
		this.lecWk = list.get(5);
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
	
	public String getProNm() {
		return proNm;
	}

	public void setProNm(String proNm) {
		this.proNm = proNm;
	}

	public String getRmNm() {
		return rmNm;
	}

	public void setRmNm(String rmNm) {
		this.rmNm = rmNm;
	}

	public String getCountAdu() {
		return countAdu;
	}

	public void setCountAdu(String countAdu) {
		this.countAdu = countAdu;
	}
	
	public String getDepNm() {
		return depNm;
	}
	
	public void setDepNm(String depNm) {
		this.depNm = depNm;
	}
	
	
	public String getSubNm() {
		return subNm;
	}
	
	public void setSubNm(String subNm) {
		this.subNm = subNm;
	}
	
	public List<String> getUpdateInfo(){
		List<String> list = new ArrayList<>();
		list.add(yr);
		list.add(sem);
		list.add(lecSub);
		list.add(lecDep);
		list.add(lecTm);
		list.add(lecWk);
		return list;
	}

	public String toString() {
		return String.format("%-5s\t%-10s\t%-10s\t%-5s\t%-3s\t%-3s\t%-3s\t%-5s\t", lecNo, depNm, subNm, yr, sem, lecTm, lecWk, countAdu);
	}
	
	public String listToString() {
		return String.format("%-5s\t%-20s\t%-20s\t%-4s\t%-4s\t%-5s\t%-5s\t", lecNo, depNm, subNm, yr, sem, lecTm, lecWk);
	}
	
	public String updateToString() {
		return String.format("%-5s\t%-20s\t%-20s\t%-4s\t%-4s\t%-5s\t%-5s\t", lecNo, lecDep, lecSub, yr, sem, lecTm, lecWk);
	}
	
	public static String columnLecture() {
		return String.format("%s\t%-20s\t%-20s\t%s\t%s\t%s\t%s\t"
				+ "\n-----------------------------------------------------------------------------------","강의번호","학과","과목","연도","학기","강의시간","요일" );
	}
	
	public String audString() {
		return String.format("%-5s\t%-10s\t%-10s\t%-5s\t%-3s\t%-3s\t%-3s\t%-5s\t%-5s\t%-5s\t", lecNo, depNm, subNm, yr, sem, lecTm, lecWk, proNm, rmNm, countAdu);
	}
	
	public static String audColumnLecture() {
		return String.format("%-5s\t%-10s\t%-10s\t%-5s\t%-3s\t%-3s\t%-3s\t%-5s\t%-5s\t%-5s\t"
				+ "\n-------------------------------------------------------------------------------------------------","강의번호","개설학과","과목","연도","학기","강의시간","요일", "교수이름", "강의실", "현재수강인원");
	}
}
