package common;

public enum ProfessorMenu {
	HOME(0, "------------------------------------------------------\n"
    		+ "1.성적입력\t    2. 성적확인\t  3. 로그아웃\n번호를 선택하세요>> "),
	AUD(1,"1. 추가입력\t0.이전메뉴\n번호를 선택하세요>>");
	
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
}
