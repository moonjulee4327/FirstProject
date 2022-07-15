package student;

public class StudentVO {
	//필드
	private String stuNo;
	private String stuDep;
	private String stuNm;
	private String stuEm;
	private String stuPneNo;
	private String stuGrd;
	private String stuAcdSt;
	private String stuBir;
	
	//생성자
	public StudentVO() {}
	
	public StudentVO(String stuNo, String stuNm, String stuEm, String stuPneNo, String stuGrd, String stuAcdSt, String stuDep,
			String stuBir) {
		this.stuNo = stuNo;
		this.stuNm = stuNm;
		this.stuEm = stuEm;
		this.stuPneNo = stuPneNo;
		this.stuGrd = stuGrd;
		this.stuAcdSt = stuAcdSt;
		this.stuBir = stuBir;
		this.stuDep = stuDep;
		}

	//메소드
	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	
	

	public String getStuNm() {
		return stuNm;
	}

	public void setStuNm(String stuNm) {
		this.stuNm = stuNm;
	}

	public String getStuDep() {
		return stuDep;
	}

	public void setStuDep(String stuDep) {
		this.stuDep = stuDep;
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

	public String getStuGrd() {
		return stuGrd;
	}

	public void setStuGrd(String stuGrd) {
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
		return String.format("%s \t %s \t %s \t %s \t %s \t %s \t %s \t %s \t", stuNo, stuNm, stuEm, stuPneNo, stuGrd, stuAcdSt, stuDep, stuBir); 
	}
	
	
	
}
