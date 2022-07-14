import common.LoginMenu;
import common.ScannerUtil;
import common.StudentMenu;
import sign.SignController;
import sign.SignVO;

public class StudentPortalView {
	public static void main(String[] args) {
		System.out.println(LoginMenu.HOME.getMenuString());
	}
	
	private SignController signController =  SignController.getInstance();
	
	public void home() {
		System.out.println("------------------------------------------");
		System.out.println("|\t\t학사관리 시스템\t\t|");
		System.out.println("------------------------------------------");
		System.out.print("ID: ");
		String id = ScannerUtil.nextLine();
		System.out.print("PW: ");
		String pw = ScannerUtil.nextLine();
		int division = signController.sign(new SignVO());
		System.out.println(division);
		switch(division) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		
			
		}
		
	}
	
}
