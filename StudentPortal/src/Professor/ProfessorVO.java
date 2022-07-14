package Professor;

public class ProfessorVO {
	//필드
	private int proNo; 		//교수번호
	private int proDep;     //학과번호
	private String depNm;	//학과명
	private String proPneNo;//교수 전화번호
	private String proEm;	//교수 이메일
	private String proBir;	//교수 생년월일
	//생성자
	public ProfessorVO(int proNo, int proDep, String depNm, String proPneNo, String proEm, String proBir) {
		super();
		this.proNo = proNo;
		this.proDep = proDep;
		this.depNm = depNm;
		this.proPneNo = proPneNo;
		this.proEm = proEm;
		this.proBir = proBir;
	}
	//메소드
	public int getProNo() {
		return proNo;
	}
	
	public int getProDep() {
		return proDep;
	}
	public void setProDep(int proDep) {
		this.proDep = proDep;
	}
	public void setProNo(int proNo) {
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
		return "ProfessorVO [proNo=" + proNo + ", proDep=" + proDep + ", depNm=" + depNm + ", proPneNo=" + proPneNo
				+ ", proEm=" + proEm + ", proBir=" + proBir + "]";
	}
	
	

}
