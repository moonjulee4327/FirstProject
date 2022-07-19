package student;

import java.util.ArrayList;
import java.util.List;

public class StudentVO {
	//필드
	private String stuNo;
	private String stuNm;
	private String stuEm;
	private String stuPneNo;
	private String stuGrd;
	private String stuAcdSt;
	private String stuDep;
	private String depNm;
	private String stuBir;
	
	//생성자
	public StudentVO() {}
	
	public StudentVO(String stuNo) {
		this.stuNo = stuNo;
	}
	
	public StudentVO(String stuNo, String stuNm, String stuEm, String stuPneNo, String stuGrd, String stuAcdSt,
			String stuDep,String depNm, String stuBir) {
		this.stuNo = stuNo;
		this.stuNm = stuNm;
		this.stuEm = stuEm;
		this.stuPneNo = stuPneNo;
		this.stuGrd = stuGrd;
		this.stuAcdSt = stuAcdSt;
		this.stuDep = stuDep;
		this.depNm = depNm;
		this.stuBir = stuBir;
	}
	
	public StudentVO(String stuNo, String stuNm, String stuEm, String stuPneNo, String stuGrd, String stuAcdSt,
			String stuDep, String stuBir) {
		this.stuNo = stuNo;
		this.stuNm = stuNm;
		this.stuEm = stuEm;
		this.stuPneNo = stuPneNo;
		this.stuGrd = stuGrd;
		this.stuAcdSt = stuAcdSt;
		this.stuDep = stuDep;
		this.stuBir = stuBir;
	}



	public StudentVO( String stuNm, String stuEm, String stuPneNo,String stuGrd, String stuDep, String stuBir) {
		this.stuNm = stuNm;
		this.stuEm = stuEm;
		this.stuPneNo = stuPneNo;
		this.stuGrd = stuGrd;
		this.stuDep = stuDep;
		this.stuBir = stuBir;
	}
	
	public StudentVO(String stuNo, List<String> list) {
		this.stuNo = stuNo;
		this.stuNm = list.get(0);
		this.stuEm = list.get(1);
		this.stuPneNo = list.get(2);
		this.stuGrd = list.get(3);
		this.stuAcdSt = list.get(4);
		this.stuDep = list.get(5);
		this.stuBir = list.get(6);
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

	public String getStuDep() {
		return stuDep;
	}

	public void setStuDep(String stuDep) {
		this.stuDep = stuDep;
	}

	public String getDepNm() {
		return depNm;
	}

	public void setDepNm(String depNm) {
		this.depNm = depNm;
	}

	public String getStuBir() {
		return stuBir;
	}

	public void setStuBir(String stuBir) {
		this.stuBir = stuBir;
	}
	
	@Override
	public String toString() {
		return String.format("%-10s\t%-10s\t%-5s\t\t%-23s\t%-10s\t%3s\t%-5s\t%-11s\t", stuNo, depNm, stuNm, stuEm, stuPneNo, stuGrd, stuAcdSt, stuBir);
	}
	
	public String updateToString() {
		return String.format("%-10s\t%-10s\t%-5s\t\t%-23s\t%-10s\t%3s\t%-5s\t%-11s\t", stuNo, stuDep, stuNm, stuEm, stuPneNo, stuGrd, stuAcdSt, stuBir);
	}

	public static String columnString() {
		return String.format("%-10s\t%-10s\t%-5s\t\t%-18s\t%-10s\t%3s\t%-5s\t%-7s\t "
				+"\n------------------------------------------------------------------------------------------------------------------", "학생번호", "학과", "학생이름", "이메일", "전화번호", "학년", "학적", "생년월일");
	}

	

	public List<String> getUpdateInfo() {
		List<String> list = new ArrayList<>();
		list.add(stuNm);
		list.add(stuEm);
		list.add(stuPneNo);
		list.add(stuGrd);
		list.add(stuAcdSt);
		list.add(stuDep);
		list.add(stuBir);
		list.add(depNm);
		return list;
	}
}
