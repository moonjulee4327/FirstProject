package rc;

public class RcVO {
	//필드
	private String stuNm;//학생이름
	private String audNo;//수강번호
	private String sc;//점수
	private String mk;//평점
	private String rk;//등급
	//학생 성적 조회 필드
	private String yr; 
	private String sem;
	private String depNm;
	private String subNm;
	private String proNm;
	private String cre;
	private String comDiv;

	
	//생성자
	public RcVO(String audNo, String sc, String mk, String rk) {
		super();
		this.audNo = audNo;
		this.sc = sc;
		this.mk = mk;
		this.rk = rk;
	}
	public RcVO(String stuNm, String audNo, String sc, String mk, String rk) {
		super();
		this.stuNm = stuNm;
		this.audNo = audNo;
		this.sc = sc;
		this.mk = mk;
		this.rk = rk;
	}
	
	public RcVO(String yr,  String sem, String depNm, String stuNm, String subNm, String proNm, String cre, String comDiv, String sc, String mk, String rk 
			  ) {
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
	
	
	//메소드
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
	
	public String allToString() {
		return String.format("%s \t %s \t %s \t %s \t %s", stuNm, audNo, sc, mk, rk);
	}
	
	public String recordToString() {
		return String.format("%s \t %s \t %s \t %s", audNo, sc, mk, rk);
	}

	public String rcStudentToString() {
		return  String.format("%s %s %s %s %s %s %s %s %s %s %s", yr, sem, depNm, stuNm, subNm, proNm, cre, comDiv, sc, mk, rk);
	}
	
	
	

}
