package common;

public enum ProfessorMenu {
	HOME(0, "------------------------------------------------------\n"
    		+ "1.성적입력\t    2. 성적확인\t  3. 로그아웃\n번호를 선택하세요>> "),
	RECORD_ENTER(1,"성적을 입력합니다.\n성적을 입력할 강의번호를 선택하세요>>"),
	RECORD_LIST(2,"성적을 조회합니다."),
	LOGOUT(3, "로그아웃 합니다.\n");
	
	private final int menu;
    private final String menuString;

    ProfessorMenu(int menu, String menuString) {
		this.menu = menu;
		this.menuString = menuString;
	}
	
	public int getMenu() {
        return menu;
    }

    public String getMenuString() {
        return menuString;
    }
    
    public static ProfessorMenu findMenu(int menu) {
    	for(ProfessorMenu number : values()) {
    		if(number.getMenu() == menu) {
    			return number;
    		}
    	}
    	return null;
    }
}
