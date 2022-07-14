package sign;

public class SignVO {
	//필드
	private String id;
	private String pw;
	
	//생성자
	public SignVO() {}

	public SignVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	//메소드
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "SignVO [id=" + id + ", pw=" + pw + "]";
	}
	
}
