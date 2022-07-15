package common;

public enum AdminMenu {
	HOME(0, "\n1.학생관리\t 2. 교수관리\t 3. 강의관리 \t4. 로그아웃\n"
    		+ "번호를 선택하세요>> "),
	STUDENT_MANAGEMENT(1,"\n11. 학생조회\t12. 학생등록\t0. 이전메뉴\n번호를 선택하세요>>"),
	STUDENT_LIST(11,"\n학생을 조회합니다.\n"),
	STUDENT_INSERT(12,"\n학생을 등록합니다.\n학생의 정보를 입력해주세요.\n"),
	PROFESSOR_MANAGEMENT(2,"\n21. 교수조회\t22. 교수등록\t0. 이전메뉴\n번호를 선택하세요>>"),
	PROFESSOR_LIST(21,"\n교수을 조회합니다.\n"),
	PROFESSOR_INSERT(22,"\n교수를 등록합니다.\n교수의 정보를 입력해주세요.\n"),
	LECTURE_MANAGEMENT(3,"\n31. 강의조회\t32. 강의개설\t0. 이전메뉴\n번호를 선택하세요>>"),
	LECTURE_LIST(31,"\n강의를 조회합니다.\n"),
	LECTURE_INSERT(32,"\n강의를 개설합니다.\n강의정보를 입력해주세요.\n"),
	LOGOUT(4, "\n로그아웃 합니다.\n");
	
	private final int menu;
    private final String menuString;

    AdminMenu(int menu, String menuString) {
		this.menu = menu;
		this.menuString = menuString;
	}
	
	public int getMenu() {
        return menu;
    }

    public String getMenuString() {
        return menuString;
    }
    public static AdminMenu findMenu(int menu) {
    	for(AdminMenu number : values()) {
    		if(number.getMenu() == menu) {
    			return number;
    		}
    	}
    	return null;
    }
    
    public static AdminMenu findStudentMenu(int menu) {
    	if((STUDENT_LIST.getMenu() <= menu
    			&& menu <=STUDENT_INSERT.getMenu())
    			|| menu == HOME.getMenu()) {
    		return findMenu(menu);
    	}
    	System.out.println("유효하지 않은 입력입니다.");
    	System.out.println();
    	return STUDENT_MANAGEMENT;
    }
    
    public static AdminMenu findProffesorMenu(int menu) {
    	if((PROFESSOR_LIST.getMenu() <= menu
    			&& menu <=PROFESSOR_INSERT.getMenu())
    			|| menu == HOME.getMenu()) {
    		return findMenu(menu);
    	}
    	System.out.println("유효하지 않은 입력입니다.");
    	System.out.println();
    	return PROFESSOR_MANAGEMENT;
    }
    
    public static AdminMenu findLectureMenu(int menu) {
    	if((LECTURE_LIST.getMenu() <= menu
    			&& menu <=LECTURE_INSERT.getMenu())
    			|| menu == HOME.getMenu()) {
    		return findMenu(menu);
    	}
    	System.out.println("유효하지 않은 입력입니다.");
    	System.out.println();
    	return LECTURE_MANAGEMENT;
    }
}
