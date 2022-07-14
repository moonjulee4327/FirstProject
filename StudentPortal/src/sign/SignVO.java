package sign;

public class SignVO {
	//필드
	private int id;
	private int pw;
	
	//생성자
	public SignVO() {}

	public SignVO(int id, int pw) {
		this.id = id;
		this.pw = pw;
	}
	
	//메소드
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPw() {
		return pw;
	}

	public void setPw(int pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "SignVO [id=" + id + ", pw=" + pw + "]";
	}
	
}
