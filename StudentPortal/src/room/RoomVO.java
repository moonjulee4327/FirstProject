package room;

import java.util.ArrayList;
import java.util.List;

public class RoomVO {
	//필드
	private String rmNo;
	private String rmNm;
	
	//생성자
	public RoomVO() {}

	public RoomVO(String rmNo) {
		this.rmNo = rmNo;
	}

	public RoomVO(String rmNo, String rmNm) {
		this.rmNo = rmNo;
		this.rmNm = rmNm;
	}

	public String getRmNo() {
		return rmNo;
	}

	public void setRmNo(String rmNo) {
		this.rmNo = rmNo;
	}

	public String getRmNm() {
		return rmNm;
	}

	public void setRmNm(String rmNm) {
		this.rmNm = rmNm;
	}

	@Override
	public String toString() {
		return String.format("%s\t\t%s\t\t", rmNo, rmNm);
	}
	
	public static String columnString() {
		return String.format("%s\t\t%s\t\t"
				+ "\n-----------------------------", "강의실번호", "강의실명");
	}

	public List<String> getUpdateInfo() {
		List<String> list = new ArrayList<>();
		list.add(rmNm);
		return list;
	}
	
	
	
}
