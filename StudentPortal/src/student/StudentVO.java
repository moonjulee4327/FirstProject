package student;

public class StudentVO {
	//필드
	private int stuNo; //학생번호
	private String stuDep; //학과번호
	private String stuNm; //학생명 
	private String stuEm; //이메일
	private String stuPneNo; //전화번호
	private int stuGrd; //학년
	private String stuAcdSt; //학적
	private String stuBir; //생년월일
	
	//생성자
	public StudentVO() {}
	
	//메소드
	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	public String getStuDep() {
		return stuDep;
	}

	public void setStuDep(String stuDep) {
		this.stuDep = stuDep;
	}
	
	public String getStuNm() {
		return stuNm;
	}
	
	public void setStuNm(String stuNm) {
		this.stuNm = stuNm;
	}

	public String getStuEm() {
		return stuEm;
	}

	
	public void setStuEm(String stuEm) {
		this.stuEm = stuEm;
	}

	public String getStuPneNo() {
		return stuPneNo;
	}

	public void setStuPneNo(String stuPneNo) {
		this.stuPneNo = stuPneNo;
	}

	public int getStuGrd() {
		return stuGrd;
	}

	public void setStuGrd(int stuGrd) {
		this.stuGrd = stuGrd;
	}

	public String getStuAcdSt() {
		return stuAcdSt;
	}

	public void setStuAcdSt(String stuAcdSt) {
		this.stuAcdSt = stuAcdSt;
	}

	public String getStuBir() {
		return stuBir;
	}

	public void setStuBir(String stuBir) {
		this.stuBir = stuBir;
	}

	@Override
	public String toString() {
		return "StudentVO [stuNo=" + stuNo + ", stuDep=" + stuDep + ", stuNm=" + stuNm + ", stuEm=" + stuEm
				+ ", stuPneNo=" + stuPneNo + ", stuGrd=" + stuGrd + ", stuAcdSt=" + stuAcdSt + ", stuBir=" + stuBir
				+ "]";
	}

	
}
