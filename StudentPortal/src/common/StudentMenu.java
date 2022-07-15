package common;

public enum StudentMenu {
	HOME(0, "------------------------------------------------------\n"
    		+ "1.수강신청\t    2. 전체성적확인\t  3. 수강내역조회\t 4.로그아웃\n번호를 선택하세요>> "),
	AUDIT_SIGN(1,"1. 추가입력\t0.이전메뉴\n번호를 선택하세요>>"),
	ALL_RECORD(2,"전체성적을 조회합니다."),
	AUDIT_HISTORY(3,"전체수강내역을 조회합니다."),
	LOGOUT(4, "로그아웃 합니다.");
	
	private final int menu;
    private final String menuString;

	StudentMenu(int menu, String menuString) {
		this.menu = menu;
		this.menuString = menuString;
	}
	
	public int getMenu() {
        return menu;
    }

    public String getMenuString() {
        return menuString;
    }
    
    public static StudentMenu findMenu(int menu) {
    	for(StudentMenu number : values()) {
    		if(number.getMenu() == menu) {
    			return number;
    		}
    	}
    	return null;
    }
}
