package common;

public enum LoginMenu {
	HOME(-1,"------------------------------------------------\n"
    		+ "\t\t학사관리시스템\n"
    		+ "------------------------------------------------\n"
    		+ "1.로그인\t\t0.프로그램 종료\n번호를 선택하세요: "),
	LOGIN(1,"아이디와 비밀번호를 입력해주세요."),
	STUDENT(2, "학생 로그인 되었습니다."),
	PROFESSOR(3, "교수 로그인 되었습니다."),
	ADMIN(4,"관리자 로그인 되었습니다."),
	RETURN(5, "이전화면으로 돌아갑니다"),
	EXIT(0,"프로그램을 종료합니다");
	
	private final int menu;
    private final String menuString;

    LoginMenu(int menu, String menuString) {
    	this.menu = menu;
		this.menuString = menuString;
	}
	
    public int getMenu() {
		return menu;
	}
    
    public String getMenuString() {
        return menuString;
    }

    public static LoginMenu findMenu(int menu) {
    	for(LoginMenu number : values()) {
    		if(number.getMenu() == menu) {
    			return number;
    		}
    	}
    	return null;
    }
	
}
