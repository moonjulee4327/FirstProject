package department;

import java.util.ArrayList;
import java.util.List;

public class DepartMentVO {
	//필드
	private String depNo;
	private String depNm;
	private String depPne;
	
	//생성자
	public DepartMentVO() {}
	public DepartMentVO(String depNo) {
		this.depNo = depNo;
	}
	public DepartMentVO(String depNo, String depNm, String depPne) {
		this.depNo = depNo;
		this.depNm = depNm;
		this.depPne = depPne;
	}

	public String getDepNo() {
		return depNo;
	}

	public void setDepNo(String depNo) {
		this.depNo = depNo;
	}

	public String getDepNm() {
		return depNm;
	}

	public void setDepNm(String depNm) {
		this.depNm = depNm;
	}

	
	public String getDepPne() {
		return depPne;
	}

	public void setDepPne(String depPne) {
		this.depPne = depPne;
	}
	
	@Override
	public String toString() {
		return String.format("%-10s\t%-10s\t%-15s\t", depNo, depNm, depPne );
	}
	
	public static String columnString() {
		return String.format("%-10s\t%-10s\t%-10s\t"
				+ "\n---------------------------------------------", "학과번호", "학과", "전화번호");
	}
	public List<String> getUpdateInfo() {
		List<String> list = new ArrayList<>();
		list.add(depNm);
		list.add(depPne);
		return list;
	}
	
	
}
