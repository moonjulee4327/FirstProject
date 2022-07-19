package subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectVO {
	// 필드
	private String subNo;
	private String subNm;
	private String comDiv;
	private String cre;
	private String subPro;
	private String proNm;
	private String subRm;

	// 생성자
	public SubjectVO(String subNo) {
		this.subNo = subNo;
	}
	public SubjectVO(String subNo, String subNm, String comDiv, String cre, String subPro, String proNm, String subRm) {
		this.subNo = subNo;
		this.subNm = subNm;
		this.comDiv = comDiv;
		this.cre = cre;
		this.subPro = subPro;
		this.proNm = proNm;
		this.subRm = subRm;
	}
	
	public SubjectVO(String subNo, String subNm, String comDiv, String cre, String subPro, String subRm) {
		this.subNo = subNo;
		this.subNm = subNm;
		this.comDiv = comDiv;
		this.cre = cre;
		this.subPro = subPro;
		this.subRm = subRm;
	}

	public SubjectVO(String subNo, List<String> list) {
		
	}
	// 매소드
	public String getSubNo() {
		return subNo;
	}

	public void setSubNo(String subNo) {
		this.subNo = subNo;
	}

	public String getCre() {
		return cre;
	}

	public void setCre(String cre) {
		this.cre = cre;
	}

	public String getSubPro() {
		return subPro;
	}

	public void setSubPro(String subPro) {
		this.subPro = subPro;
	}

	public String getSubRm() {
		return subRm;
	}

	public void setSubRm(String subRm) {
		this.subRm = subRm;
	}

	public String getSubNm() {
		return subNm;
	}

	public void setSubNm(String subNm) {
		this.subNm = subNm;
	}

	public String getComDiv() {
		return comDiv;
	}

	public void setComDiv(String comDiv) {
		this.comDiv = comDiv;
	}

	@Override
	public String toString() {
		return String.format("%s\t%s\t\t%s\t%s\t%s\t\t%s\t%s\t", subNo, subNm, comDiv, cre, subPro, proNm, subRm);
	}
	
	public static String columnString() {
		return String.format("%s\t%s\t\t%s\t%s\t%s\t\t%s\t%s\t"
				+"\n-----------------------------------------------------------------------------------------------", "과목번호", "과목", "이수구분", "학점", "교수번호","교수이름", "강의실");
	}
	
	public List<String> getUpdateInfo() {
		List<String> list = new ArrayList<>();
		list.add(subNm);
		list.add(comDiv);
		list.add(cre);
		list.add(subPro);
		list.add(subRm);
		return list;
	}
	
	public static String updateColumnString() {
		return String.format("%s\t%s\t\t%s\t%s\t%s\t\t%s\t"
				+"\n----------------------------------------------------------------------", "과목번호", "과목", "이수구분", "학점", "교수번호", "강의실");
	}
	public String updateToString() {
		return String.format("%s\t%s\t\t%s\t%s\t%s\t\t%s\t", subNo, subNm, comDiv, cre, subPro, subRm);
	}

	

}
