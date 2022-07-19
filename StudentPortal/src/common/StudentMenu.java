package common;

public enum StudentMenu {
	  HOME(0, "------------------------------------------------------\n"
	          + "1.수강신청\t  2.수강신청취소\t  3. 전체성적확인\t  4. 수강내역조회\t 5.로그아웃\n번호를 선택하세요>> "),
	   AUDIT_SIGN(1,"수강을 신청합니다."),
	   AUDIT_CANCEL(2,"수강신청을 취소합니다."),
	   ALL_RECORD(3,"전체성적을 조회합니다."),
	   AUDIT_HISTORY(4,"전체수강내역을 조회합니다."),
	   LOGOUT(5, "로그아웃 합니다.");
	
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
