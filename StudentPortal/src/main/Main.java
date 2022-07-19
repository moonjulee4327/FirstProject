package main;
import Professor.ProfessorController;
import common.AdminMenu;
import common.LoginMenu;
import common.ProfessorMenu;
import common.ScannerUtil;
import common.StudentMenu;
import department.DepartMentController;
import lecture.LectureController;
import record.RecordController;
import room.RoomController;
import sign.SignController;
import sign.SignVO;
import student.StudentController;
import subject.SubjectController;

public class Main {
	private static SignVO session = new SignVO();
	private static StudentPortalView view = StudentPortalView.getInstance();
	private static SignController signController = SignController.getInstance();
	private static StudentController studentController = StudentController.getInstance();
	private static LectureController lectureController = LectureController.getInstance();
	private static ProfessorController professorController = ProfessorController.getInstance();
	private static SubjectController subController = SubjectController.getInstance();
	private static RecordController recordController = RecordController.getInstance();
	private static DepartMentController depController = DepartMentController.getInstance();
	private static RoomController roomController = RoomController.getInstance();
	public static void main(String[] args) {
		new Main().run();
		ScannerUtil.close();
	}
	// 학번, 교수번호 자동생성 만들기
	// 학생은 1학년 재학을 필수로 입력.
	// DB쿼리작성
	//		학번, 사번 자동입력
	// 학번은 현재년도 + 학과번호 + 연도와 학과가 같은 개인식별범위에서 max + 1
	// 학생, 교수의 수정도 동일 학과가 변경되면 학번도 변경됨.
	// 기본키의 중복제약조건에 걸리지 않으면 기본키도 변경가능
	public void run() {
		MainLoop:
		while(true) {
			try {
				System.out.print(LoginMenu.HOME.getMenuString());
				int intMenu = view.getMenu();
				LoginMenu menu = LoginMenu.findMenu(intMenu);
				switch(menu) {
				case LOGIN:
					LoginMenu resultLogin = view.sign(signController);
					System.out.println(resultLogin.getMenuString());
					Logout:
					while(true) {
						try {
							switch(resultLogin) {
								case STUDENT:
									System.out.print(StudentMenu.HOME.getMenuString());
									intMenu = view.getMenu();
									StudentMenu stdMenu = StudentMenu.findMenu(intMenu);
									switch (stdMenu) {
										case AUDIT_SIGN:
											stdMenu = view.auditSign(lectureController,recordController);
											break;
										case AUDIT_CANCEL:
			                                 stdMenu = view.auditSignCancel(lectureController, recordController);
			                                 break;
										case ALL_RECORD:
											stdMenu = view.allRecord(recordController);
											break;
										case AUDIT_HISTORY:
											stdMenu = view.auditHistory(lectureController);
											break;
										case HOME:
											break;
										case LOGOUT:
											break Logout;
									}
									break;
									
									
								case PROFESSOR:
									System.out.print(ProfessorMenu.HOME.getMenuString());
									intMenu = view.getMenu();
									ProfessorMenu pfMenu = ProfessorMenu.findMenu(intMenu);
									switch(pfMenu) {
										case RECORD_LIST:
											pfMenu = view.recordList(recordController);
											break;
										case RECORD_ENTER:
											pfMenu = view.recordEnter(recordController);
											break;
										case HOME:
											break;
										case LOGOUT:
											break Logout;
									}
									break;
									
									
								case ADMIN:
									System.out.print(AdminMenu.HOME.getMenuString());
									intMenu = view.getMenu();
									AdminMenu adminMenu = AdminMenu.findMenu(intMenu);
									SubMenu:
									while(true) {
										switch(adminMenu) {
											case STUDENT_MANAGEMENT:
												System.out.print(adminMenu.getMenuString());
												intMenu = view.getMenu();
												adminMenu = AdminMenu.findStudentMenu(intMenu);
												switch(adminMenu) {
													case STUDENT_LIST:
														adminMenu = view.studentList(studentController);
														break;
													case STUDENT_INSERT:
														adminMenu = view.studentInsert(studentController,depController);
														break;
													case STUDENT_UPDATE:
														adminMenu = view.studentUpdate(studentController,depController);
														break;
													case STUDENT_DELETE:
														adminMenu = view.studentDelete(studentController);
														break;
													case HOME:
														break SubMenu;
												}
												break;
											case PROFESSOR_MANAGEMENT:
												System.out.print(adminMenu.getMenuString());
												intMenu = view.getMenu();
												adminMenu = AdminMenu.findProffesorMenu(intMenu);
												switch(adminMenu) {
													case PROFESSOR_LIST:
														adminMenu = view.professorList(professorController);
														break;
													case PROFESSOR_INSERT:
														adminMenu = view.professorInsert(professorController,depController);
														break;
													case PROFESSOR_UPDATE:
														adminMenu = view.professorUpdate(professorController,depController);
														break;
													case PROFESSOR_DELETE:
														adminMenu = view.professorDelete(professorController);
														break;
													case HOME:
														break SubMenu;
												}
												break;
											case LECTURE_MANAGEMENT:
												System.out.print(adminMenu.getMenuString());
												intMenu = view.getMenu();
												adminMenu = AdminMenu.findLectureMenu(intMenu);
												switch(adminMenu) {
													case LECTURE_LIST:
														adminMenu = view.lectureList(lectureController);
														break;
													case LECTURE_INSERT:
														adminMenu = view.lectureInsert(lectureController,depController,subController);
														break;
													case LECTURE_UPDATE:
														adminMenu = view.lectureUpdate(lectureController,subController
																							,depController);
														break;
													case HOME:
														break SubMenu;
												}
												break;
												
											case SUBJECT_MANAGEMENT:
												System.out.print(adminMenu.getMenuString());
												intMenu = view.getMenu();
												adminMenu = AdminMenu.findSubjectMenu(intMenu);
												switch(adminMenu) {
													case SUBJECT_LIST:
														adminMenu = view.subjectList(subController);
														break;
													case SUBJECT_INSERT:
														adminMenu = view.subjectInsert(subController,professorController
																						,roomController);
														break;
													case SUBJECT_UPDATE:
														adminMenu = view.subjectUpdate(subController,professorController
																						,roomController);
														break;
													case HOME:
														break SubMenu;
												}
												break;
												
											case DEPARTMENT_MANAGEMENT:
												System.out.print(adminMenu.getMenuString());
												intMenu = view.getMenu();
												adminMenu = AdminMenu.findDepartMentMenu(intMenu);
												switch(adminMenu) {
													case DEPARTMENT_LIST:
														adminMenu = view.departmentList(depController);
														break;
													case DEPARTMENT_INSERT:
														adminMenu = view.departmentInsert(depController);
														break;
													case DEPARTMENT_UPDATE:
														adminMenu = view.departmentUpdate(depController);
														break;
													case DEPARTMENT_DELETE:
														adminMenu = view.departmentDelete(depController);
														break;
													case HOME:
														break SubMenu;
												}
												break;
											case ROOM_MANAGEMENT:
												System.out.print(adminMenu.getMenuString());
												intMenu = view.getMenu();
												adminMenu = AdminMenu.findRoomMenu(intMenu);
												switch(adminMenu) {
													case ROOM_LIST:
														adminMenu = view.roomList(roomController);
														break;
													case ROOM_INSERT:
														adminMenu = view.roomInsert(roomController);
														break;
													case ROOM_UPDATE:
														adminMenu = view.roomUpdate(roomController);
														break;
													case ROOM_DELETE:
														adminMenu = view.roomDelete(roomController);
														break;
													case HOME:
														break SubMenu;
												}
												break;
											case LOGOUT:
												System.out.println(adminMenu.getMenuString());
												break Logout;
												
											case HOME:
												break SubMenu;
										}
										System.out.println();
									}
									System.out.println();
									break;
								case RETURN:
									System.out.println("이전메뉴로 돌아갑니다");
									break Logout;
							}
						}catch(Exception e) {
							System.out.println("\n잘못된 입력입니다.");
							System.out.println("메인화면으로 돌아갑니다.");
							System.out.println();
						}
					}
					break;
				case EXIT:
					System.out.println(menu.getMenuString());
					break MainLoop;
				default:
					throw new NullPointerException();
				}
			
			}catch(NullPointerException e) {
				System.out.println("\n잘못된 입력입니다.");
				System.out.println("로그인화면으로 돌아갑니다.");
				System.out.println();
			}
		}
	}

	public static SignVO getSession() {
		return session;
	}

	
}
