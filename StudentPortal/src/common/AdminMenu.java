package common;

public enum AdminMenu {
	HOME(0, "\n1. 학생관리\t2. 교수관리\t3. 강의관리 \t4. 교과목관리\n5. 학과관리 \t6. 강의실관리\t7. 로그아웃\n"
    		+ "번호를 선택하세요>> "),
	STUDENT_MANAGEMENT(1,"\n1. 학생조회\t2. 학생등록\t3. 학생수정\t4. 학생삭제\t0. 이전메뉴\n번호를 선택하세요>>"),
	STUDENT_LIST(11,"\n학생목록을 조회합니다.\n"),
	STUDENT_INSERT(12,"\n학생을 등록합니다.\n등록할 학생정보를 입력해주세요.\n"),
	STUDENT_UPDATE(13,"\n학생을 수정합니다.\n수정할 학생정보를 입력해주세요.\n"),
	STUDENT_DELETE(14,"\n학생을 삭제합니다.\n삭제할 학생정보를 입력해주세요.\n"),
	PROFESSOR_MANAGEMENT(2,"\n1. 교수조회\t2. 교수등록\t3. 교수수정\t4. 교수삭제\t0. 이전메뉴\n번호를 선택하세요>>"),
	PROFESSOR_LIST(21,"\n교수목록을 조회합니다.\n"),
	PROFESSOR_INSERT(22,"\n교수를 등록합니다.\n등록할 교수정보를 입력해주세요.\n"),
	PROFESSOR_UPDATE(23,"\n교수를 수정합니다.\n수정할 교수정보를 입력해주세요.\n"),
	PROFESSOR_DELETE(24,"\n교수를 삭제합니다.\n삭제할 교수정보를 입력해주세요.\n"),
	LECTURE_MANAGEMENT(3,"\n1. 강의조회\t2. 강의개설\t3. 강의수정\t0. 이전메뉴\n번호를 선택하세요>>"),
	LECTURE_LIST(31,"\n강의목록을 조회합니다.\n"),
	LECTURE_INSERT(32,"\n강의를 개설합니다.\n등록할 강의정보를 입력해주세요.\n"),
	LECTURE_UPDATE(33,"\n강의를 수정합니다.\n수정할 강의정보를 입력해주세요.\n"),
	SUBJECT_MANAGEMENT(4,"\n1. 교과목조회\t2. 교과목등록\t3. 교과목수정\t0. 이전메뉴\n번호를 선택하세요>>"),
	SUBJECT_LIST(41,"\n교과목목록을 조회합니다.\n"),
	SUBJECT_INSERT(42,"\n교과목을 등록합니다.\n등록할 교과목정보를 입력해주세요.\n"),
	SUBJECT_UPDATE(43,"\n교과목을 수정합니다.\n수정할 교과목정보를 입력해주세요.\n"),
	DEPARTMENT_MANAGEMENT(5,"\n1. 학과조회\t2. 학과등록\t3. 학과수정\t4. 학과삭제\t0. 이전메뉴\n번호를 선택하세요>>"),
	DEPARTMENT_LIST(51,"\n학과목록을 조회합니다.\n"),
	DEPARTMENT_INSERT(52,"\n학과를 개설합니다.\n등록할 학과정보를 입력해주세요.\n"),
	DEPARTMENT_UPDATE(53,"\n학과를 수정합니다.\n수정할 학과정보를 입력해주세요.\n"),
	DEPARTMENT_DELETE(54,"\n학과를 삭제합니다.\n삭제할 학과정보를 입력해주세요.\n"),
	ROOM_MANAGEMENT(6,"\n1. 강의실조회\t2. 강의실등록\t3. 강의실수정\t4. 강의실삭제\t0. 이전메뉴\n번호를 선택하세요>>"),
	ROOM_LIST(61,"\n강의실목록을 조회합니다.\n"),
	ROOM_INSERT(62,"\n강의실을 개설합니다.\n등록할 강의실정보를 입력해주세요.\n"),
	ROOM_UPDATE(63,"\n강의실을 수정합니다.\n수정할 강의실정보를 입력해주세요.\n"),
	ROOM_DELETE(64,"\n강의실을 삭제합니다.\n삭제할 강의실정보를 입력해주세요.\n"),
	LOGOUT(7, "\n로그아웃 합니다.\n");
	
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
    	if(menu != 0) {
    		menu = STUDENT_MANAGEMENT.getMenu()*10 + menu;
    	}
    	if((STUDENT_LIST.getMenu() <= menu
    			&& menu <=STUDENT_DELETE.getMenu())
    			|| menu == HOME.getMenu()) {
    		return findMenu(menu);
    	}
    	System.out.println("유효하지 않은 입력입니다.");
    	System.out.println();
    	return STUDENT_MANAGEMENT;
    }
    
    public static AdminMenu findProffesorMenu(int menu) {
    	if(menu != 0) {
    		menu = PROFESSOR_MANAGEMENT.getMenu()*10 + menu;
    	}
    	if((PROFESSOR_LIST.getMenu() <= menu
    			&& menu <=PROFESSOR_DELETE.getMenu())
    			|| menu == HOME.getMenu()) {
    		return findMenu(menu);
    	}
    	System.out.println("유효하지 않은 입력입니다.");
    	System.out.println();
    	return PROFESSOR_MANAGEMENT;
    }
    
    public static AdminMenu findLectureMenu(int menu) {
    	if(menu != 0) {
    		menu = LECTURE_MANAGEMENT.getMenu()*10 + menu;
    	}
    	if((LECTURE_LIST.getMenu() <= menu
    			&& menu <=LECTURE_UPDATE.getMenu())
    			|| menu == HOME.getMenu()) {
    		return findMenu(menu);
    	}
    	System.out.println("유효하지 않은 입력입니다.");
    	System.out.println();
    	return LECTURE_MANAGEMENT;
    }
    
    public static AdminMenu findSubjectMenu(int menu) {
    	if(menu != 0) {
    		menu = SUBJECT_MANAGEMENT.getMenu()*10 + menu;
    	}
    	if((SUBJECT_LIST.getMenu() <= menu
    			&& menu <=SUBJECT_UPDATE.getMenu())
    			|| menu == HOME.getMenu()) {
    		return findMenu(menu);
    	}
    	System.out.println("유효하지 않은 입력입니다.");
    	System.out.println();
    	return SUBJECT_MANAGEMENT;
    }
    
    public static AdminMenu findDepartMentMenu(int menu) {
    	if(menu != 0) {
    		menu = DEPARTMENT_MANAGEMENT.getMenu()*10 + menu;
    	}
    	if((DEPARTMENT_LIST.getMenu() <= menu
    			&& menu <=DEPARTMENT_DELETE.getMenu())
    			|| menu == HOME.getMenu()) {
    		return findMenu(menu);
    	}
    	System.out.println("유효하지 않은 입력입니다.");
    	System.out.println();
    	return DEPARTMENT_MANAGEMENT;
    }
    
    public static AdminMenu findRoomMenu(int menu) {
    	if(menu != 0) {
    		menu = ROOM_MANAGEMENT.getMenu()*10 + menu;
    	}
    	if((ROOM_LIST.getMenu() <= menu
    			&& menu <=ROOM_DELETE.getMenu())
    			|| menu == HOME.getMenu()) {
    		return findMenu(menu);
    	}
    	System.out.println("유효하지 않은 입력입니다.");
    	System.out.println();
    	return ROOM_MANAGEMENT;
    }
}
