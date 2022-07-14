import common.LoginMenu;

public class Main {
	static StudentPortalView view = new StudentPortalView();
	
	public static void main(String[] args) {
		new Main().run();
	}
	
	public static void run() {
		Program:
		while(true) {
			LoginMenu login = LoginMenu.HOME;
			System.out.println(login.getMenuString());
			switch(login) {
			case HOME:
				
				break;
			case EXIT:
				break Program;
				default:
					System.out.println("유효하지 않은 입력입니다.");
					break;
			}
		}
	}
}
