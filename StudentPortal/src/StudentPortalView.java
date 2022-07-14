import common.ScannerUtil;
import sign.SignController;
import sign.SignVO;


public class StudentPortalView {
	
	
	public void sign(SignController signController) {
		
		
		
		System.out.print("ID: ");
		String id = ScannerUtil.nextLine();
		System.out.print("PW: ");
		String pw = ScannerUtil.nextLine();
		int division = signController.sign(new SignVO());
		System.out.println(division);
		switch(division) {
		case 1:
			System.out.println("학생로그인");
			break;
		case 2:
			System.out.println("교수로그인");
			break;
		case 3:
			System.out.println("관리자 로그인");
			break;
		}
		
	}
	
}
