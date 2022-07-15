package sub;

public class SubVO {
	// 필드
	private int subNo;
	private int cre;
	private int subPro;
	private int subRm;
	private String subNm;
	private String comDiv;

	// 생성자
	public SubVO(int subNo, int cre, int subPro, int subRm, String subNm, String comDiv) {
		super();
		this.subNo = subNo;
		this.cre = cre;
		this.subPro = subPro;
		this.subRm = subRm;
		this.subNm = subNm;
		this.comDiv = comDiv;
	}

	// 매소드
	public int getSubNo() {
		return subNo;
	}

	public void setSubNo(int subNo) {
		this.subNo = subNo;
	}

	public int getCre() {
		return cre;
	}

	public void setCre(int cre) {
		this.cre = cre;
	}

	public int getSubPro() {
		return subPro;
	}

	public void setSubPro(int subPro) {
		this.subPro = subPro;
	}

	public int getSubRm() {
		return subRm;
	}

	public void setSubRm(int subRm) {
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
		return "과목번호: " + subNo + " 학점: " + cre + " 교수번호: " + subPro + " 강의실 번호: " + subRm + " 과목명: " + subNm + " 이수구분: " + comDiv;
	}

}
