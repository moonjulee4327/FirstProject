package record;

public class RecordVO {
	private String stuNm;//학생이름
	private String audNo;//수강번호
	private String lecNo;
	private String sc;//점수
	private String mk;//평점
	private String rk;//등급
	private String yr; 
	private String sem;
	private String depNm;
	private String subNm;
	private String proNm;
	private String cre;
	private String comDiv;
	
	
	//생성자
	public RecordVO(String audNo, String sc) {
		this.audNo = audNo;
		this.sc = sc;
	}
	
	public RecordVO(String lecNo, String subNm, String cre, String proNm) {
		this.lecNo = lecNo;
		this.subNm = subNm;
		this.cre = cre;
		this.proNm = proNm;
	}
	
	public RecordVO(String stuNm, String audNo, String sc, String mk, String rk) {
		this.stuNm = stuNm;
		this.audNo = audNo;
		this.sc = sc;
		this.mk = mk;
		this.rk = rk;
	}
	
	public RecordVO(String yr,  String sem, String depNm, String stuNm, String subNm, 
			String proNm, String cre, String comDiv, String sc, String mk, String rk ) {
		this.stuNm = stuNm;
		this.sc = sc;
		this.mk = mk;
		this.rk = rk;
		this.yr = yr;
		this.sem = sem;
		this.depNm = depNm;
		this.subNm = subNm;
		this.proNm = proNm;
		this.cre = cre;
		this.comDiv = comDiv;
	}
	
	//메서드
	
	public String getLecNo() {
		return lecNo;
	}

	public void setLecNo(String lecNo) {
		this.lecNo = lecNo;
	}
	
	public String getStuNm() {
		return stuNm;
	}

	public void setStuNm(String stuNm) {
		this.stuNm = stuNm;
	}

	public String getAudNo() {
		return audNo;
	}

	public void setAudNo(String audNo) {
		this.audNo = audNo;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public String getMk() {
		return mk;
	}

	public void setMk(String mk) {
		this.mk = mk;
	}

	public String getRk() {
		return rk;
	}

	public void setRk(String rk) {
		this.rk = rk;
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

	public String getProNm() {
		return proNm;
	}

	public void setProNm(String proNm) {
		this.proNm = proNm;
	}

	public String getCre() {
		return cre;
	}

	public void setCre(String cre) {
		this.cre = cre;
	}

	public String getComDiv() {
		return comDiv;
	}

	public void setComDiv(String comDiv) {
		this.comDiv = comDiv;
	}
	
	public static String colunmAllToString(){
		return String.format("%s \t %s \t %s \t %s \t %s"
				+ "\n-----------------------------------------","수강번호", "이름", "원점수", "평점", "점수");
	}
	
	public String allToString() {
		return String.format("%s \t %s \t %s \t %s \t %s", audNo, stuNm, sc, mk, rk);
	}
	
	public static String recordListString() {
		return String.format("%-5s\t%-9s\t%-5s\t%-10s\t"
				+ "\n-----------------------------------------", "강의번호", "과목", "학점", "교수이름");
	}
	
	public String recordToString() {
		return String.format("%s\t%s\t\t%s\t%s\t",lecNo, subNm, cre, proNm);
	}
	
	public static String studentRecordList() {
		return String.format("%s\t%s\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t%s\t\t%s\t%s\t%s\t"
				+ "\n---------------------------------------------------------------------------------------------------------------------------", "연도","학기","학과","학생이름","과목","교수이름","학점","이수구분","점수","평점","등급");
	}
	
	public String rcStudentToString() {
		return  String.format("%-5s\t%-3s\t%-10s\t%-10s\t%-10s\t%-10s\t%-5s\t%-5s\t\t%-5s\t%-5s\t%-5s\t", yr, sem, depNm, stuNm, subNm, proNm, cre, comDiv, sc, mk, rk);
	}
	
}
