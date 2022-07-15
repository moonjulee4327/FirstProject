package Professor;

public class ProfessorVO {
	//필드
	private String proNo; 		//교수번호
	private String proDep;     //학과번호
	private String proNm;   //교수명
	private String depNm;	//학과명
	private String proPneNo;//교수 전화번호
	private String proEm;	//교수 이메일
	private String proBir;	//교수 생년월일
	//생성자
	 
	public ProfessorVO(String proNo, String proDep, String proNm, String depNm, String proPneNo, String proEm,
			String proBir) {
		super();
		this.proNo = proNo;
		this.proDep = proDep;
		this.proNm = proNm;
		this.depNm = depNm;
		this.proPneNo = proPneNo;
		this.proEm = proEm;
		this.proBir = proBir;
	}
	
	public ProfessorVO(String proNo, String proDep, String proNm, String proPneNo, String proEm, String proBir) {
		super();
		this.proNo = proNo;
		this.proDep = proDep;
		this.proNm = proNm;
		this.proPneNo = proPneNo;
		this.proEm = proEm;
		this.proBir = proBir;
	}

	//메소드
	public String getProNo() {
		return proNo;
	}
	
	public String getProDep() {
		return proDep;
	}
	
	public String getProNm() {
		return proNm;
	}

	public void setProNm(String proNm) {
		this.proNm = proNm;
	}

	public void setProDep(String proDep) {
		this.proDep = proDep;
	}
	public void setProNo(String proNo) {
		this.proNo = proNo;
	}
	public String getDepNm() {
		return depNm;
	}
	public void setDepNm(String depNm) {
		this.depNm = depNm;
	}
	public String getProPneNo() {
		return proPneNo;
	}
	public void setProPneNo(String proPneNo) {
		this.proPneNo = proPneNo;
	}
	public String getProEm() {
		return proEm;
	}
	public void setProEm(String proEm) {
		this.proEm = proEm;
	}
	public String getProBir() {
		return proBir;
	}
	public void setProBir(String proBir) {
		this.proBir = proBir;
	}
	@Override
	public String toString() {
		return "교수번호 :" + proNo + ", 학과번호 :" + proDep + ", 학과이름 :" + depNm + ", 전화번호 :" + proPneNo
				+ ", E-mail :" + proEm + ", 생년월일 :" + proBir;
	}
	
	

}
