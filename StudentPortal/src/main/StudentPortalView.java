package main;

import java.util.ArrayList;
import java.util.List;

import Professor.ProfessorController;
import Professor.ProfessorVO;
import common.AdminMenu;
import common.LoginMenu;
import common.ProfessorMenu;
import common.ScannerUtil;
import common.StudentMenu;
import department.DepartMentController;
import department.DepartMentVO;
import lecture.LectureController;
import lecture.LectureVO;
import record.RecordVO;
import room.RoomController;
import room.RoomVO;
import record.RecordController;
import record.RecordVO;
import sign.SignController;
import sign.SignVO;
import student.StudentController;
import student.StudentVO;
import subject.SubjectController;
import subject.SubjectVO;

public class StudentPortalView {
	private static StudentPortalView instance = new StudentPortalView();

	private StudentPortalView() {
	}

	public static StudentPortalView getInstance() {
		return instance;
	}

	public int getMenu() {
		return ScannerUtil.nextInt();
	}

	private boolean cancel(String message) {
		if (message.equals("0")) {
			System.out.println("\n입력을 취소합니다.");
			System.out.println("이전메뉴로 돌아갑니다.");
			return true;
		}
		return false;
	}
	
	public AdminMenu getAdminMenu() {
		int temp = getMenu();
		if (temp != 0 && AdminMenu.findMenu(temp) != null) {
			return AdminMenu.findMenu(temp);
		}
		return AdminMenu.HOME;
	}
	
	public LoginMenu sign(SignController signController) {
		while (true) {
			System.out.println("\n이전화면으로 돌아가려면 ID에 0을 눌러주세요.");
			System.out.print("ID: ");
			String id = ScannerUtil.nextLine();
			if (id.equals("0")) {
				return LoginMenu.RETURN;
			}
			System.out.print("PW: ");
			String pw = ScannerUtil.nextLine();
			System.out.println();
			int division = signController.sign(new SignVO(id, pw));
			if (division != 0) {
				return LoginMenu.findMenu(division);
			}
		}
	}
	// 학생
	public StudentMenu auditSign(LectureController lectureController,RecordController recordController) {
		Labal : 
		while(true) {
			System.out.println();
			System.out.println(StudentMenu.AUDIT_SIGN.getMenuString());
			System.out.println();
			System.out.println(LectureVO.audColumnLecture());
			List<LectureVO> selectLectures = lectureController.audSelect();
			for(LectureVO vo : selectLectures) {
				System.out.println(vo.audString());
			}
			System.out.println();
			System.out.println("메인 메뉴로 돌아가려면 강의번호에 0을 입력하세요.");
			System.out.print("강의 번호를 입력하세요>>");
			String lecNo = ScannerUtil.nextLine();
			if(cancel(lecNo)) {
				break;
			}
			List<LectureVO> list = lectureController.audSelectSession();
			for(LectureVO vo : list) {
				if(vo.getLecNo().equals(lecNo)) {
					System.out.println("이미 수강중인 강의입니다.");
					continue Labal;
				}
			}
			int audInsert = lectureController.audInsert(lecNo);
			if(audInsert == 1) {
				String audNo = lectureController.selectOneAud(lecNo);
				int insertRecord = recordController.insertRecord(audNo);
				if(insertRecord == 1) {
					System.out.println("수강신청이 완료되었습니다.");
				} else {
					System.out.println("알 수 없는 오류입니다. 수강신청 취소 후 다시 신청해주세요.");
				}
			} else {
				System.out.println("유효하지 않은 입력입니다.");
				System.out.println("입력한 정보를 확인해주세요.");
			}
		}
		return StudentMenu.HOME;
	}
	
	public StudentMenu auditSignCancel (LectureController lectureController,RecordController recordController) {
	      while(true) {
		      System.out.println(StudentMenu.AUDIT_CANCEL.getMenuString());
		      System.out.println("");
		      System.out.println(LectureVO.audColumnLecture());
		      List<LectureVO> list = lectureController.beforeDelete();
		      for(LectureVO vo : list) {
		         System.out.println(vo.audString());
		      }
		      System.out.println("");
		      System.out.print("수강 번호를 입력하세요>>");
		      String audNo = ScannerUtil.nextLine();
		      if(cancel(audNo)) {
		         System.out.println("삭제를 취소합니다.");
		         break;
		      }
		      LectureVO lectureVO = lectureController.audSelectOneSession(new LectureVO(audNo));
		      System.out.println(lectureVO);
		      System.out.print("위 수강을 삭제하시겠습니까?(y or n) >>");
		      String yesOrNo = ScannerUtil.nextLine();
		      if(yesOrNo.equalsIgnoreCase("y")) {
		         int deleteAudSign = lectureController.audDelete(lectureVO);
		         if(deleteAudSign ==1) {
	        		 System.out.println("수강신청이 취소되었습니다.");
	        		 break;
		         } else {
		        	 System.out.println("유효하지 않은 입력입니다.");
						System.out.println("입력한 정보를 확인해주세요.");
		         		break;
		         }
		      }
	      }
	      return StudentMenu.HOME;
	   }


	public StudentMenu allRecord(RecordController recordController) {
		System.out.println(StudentMenu.ALL_RECORD.getMenuString());
		System.out.println();
		List<RecordVO> rcStudentSelects = recordController.rcStudentSelect();
		System.out.println(RecordVO.studentRecordList());
		for(RecordVO vo : rcStudentSelects) {
			System.out.println(vo.rcStudentToString());
		}
		System.out.println();
		return StudentMenu.HOME;
	}

	public StudentMenu auditHistory(LectureController lectureController) {
		System.out.println(StudentMenu.AUDIT_HISTORY.getMenuString());
		System.out.println();
		System.out.println(LectureVO.audColumnLecture());
		List<LectureVO> list = lectureController.audSelectSession();
		for (LectureVO vo : list) {
			System.out.println(vo.audString());
		}
		System.out.println();
		return StudentMenu.HOME;
	}
	
	public ProfessorMenu recordList(RecordController rcController) {
		System.out.println(ProfessorMenu.RECORD_LIST.getMenuString());
		System.out.println();
		System.out.println(RecordVO.recordListString());
		List<RecordVO> rcProfessor = rcController.selectSub();
		for (RecordVO vo : rcProfessor) {
			System.out.println(vo.recordToString());
		}
		System.out.println();
		System.out.println("조회를 취소하려면 강의번호에 0을 입력하세요.");
		System.out.print("강의번호를 입력하세요(예: 1)>> ");
		String audLec = ScannerUtil.nextLine();
		if(cancel(audLec)) {
			return ProfessorMenu.HOME;
		}
		List<RecordVO> stu = rcController.selectStu(audLec);
		System.out.println( RecordVO.colunmAllToString());
		for (RecordVO vo : stu) {
			System.out.println(vo.allToString());
		}
		return ProfessorMenu.HOME;
	}

	public ProfessorMenu recordEnter(RecordController rcController) {
		System.out.println(ProfessorMenu.RECORD_ENTER.getMenuString());
		System.out.println("");
		System.out.println(RecordVO.recordListString());
		List<RecordVO> rcProfessor = rcController.selectSub();
		for (RecordVO vo : rcProfessor) {
			System.out.println(vo.recordToString());
		}
		rcProfessor.clear();
		System.out.println();
		System.out.println("이전메뉴 이동은 강의번호에 0을 입력하세요.");
		System.out.print("강의번호를 입력하세요>> ");
		String audLec = ScannerUtil.nextLine();
		if(cancel(audLec)) {
			return ProfessorMenu.HOME;
		}
		while(true) {
			List<RecordVO> stu = rcController.selectStu(audLec);
			System.out.println( RecordVO.colunmAllToString());
			for (RecordVO vo : stu) {
				System.out.println(vo.allToString());
			}
			System.out.println("성적입력을 취소하려면 수강번호에 0을 입력하세요.");
			System.out.print("성적을 입력할 학생의 수강번호를 선택하세요>> ");
			String audNo = ScannerUtil.nextLine();
			if(cancel(audNo)) {
				break;
			}
			System.out.print("학생의 원점수를 입력하세요>> ");
			String sc = ScannerUtil.nextLine();
			int updateRc = rcController.updateRc(new RecordVO(audNo, sc));
			if (updateRc == 1) {
				System.out.println("성적이 입력되었습니다.");
			} else {
				System.out.println("유효하지 않은 입력입니다.");
				System.out.println("입력한 정보를 확인해주세요.");
			}
		}
		return ProfessorMenu.HOME;
	}
	
	public AdminMenu studentList(StudentController studentController) {
		System.out.println(AdminMenu.STUDENT_LIST.getMenuString());
		System.out.println(StudentVO.columnString());
		List<StudentVO> list = studentController.selectStudent();
		for (StudentVO vo : list) {
			System.out.println(vo);
		}
		System.out.println();
		return AdminMenu.STUDENT_MANAGEMENT;
	}
	
	//1학년 재학만 입력받음.
	public AdminMenu studentInsert(StudentController studentController, DepartMentController depController) {
		while (true) {
			System.out.print(AdminMenu.STUDENT_INSERT.getMenuString());
			studentList(studentController);
			System.out.println("입력을 취소하려면 학생명에 0을 입력하세요.");
			System.out.print("이름을 입력하세요>>");
			String stuNm = ScannerUtil.nextLine();
			if (cancel(stuNm)) {
				break;
			}
			System.out.print("E-mail을 입력하세요>>");
			String stuEm = ScannerUtil.nextLine();
			System.out.print("전화번호를 입력하세요>>");
			String stuPneNo = ScannerUtil.nextLine();
			System.out.print("학년을 입력하세요>>");
			String stuGrd = ScannerUtil.nextLine();
			departmentList(depController);
			System.out.print("학과번호를 입력하세요>>");
			String stuDep = ScannerUtil.nextLine();
			System.out.print("생년월일을 입력하세요(예: 950102)>>");
			String stuBir = ScannerUtil.nextLine();
			int insertStudent = studentController
					.insertStudent(new StudentVO(stuNm, stuEm, stuPneNo,stuGrd, stuDep, stuBir));
			if (insertStudent == 1) {
				System.out.println("\n학생이 등록되었습니다.");
				break;
			} else {
				System.out.println("유효하지 않은 입력입니다.");
				System.out.println("입력한 정보를 확인해주세요.");
			}
		}
		return AdminMenu.STUDENT_MANAGEMENT;
	}

	public AdminMenu studentUpdate(StudentController studentController, DepartMentController depController) {
		System.out.print(AdminMenu.STUDENT_UPDATE.getMenuString());
		while(true) {
			studentList(studentController);
			System.out.println("수정을 취소하려면 학생번호에 0을 입력하세요.");
			System.out.print("정보 변경을 원하는 학생의 학생번호를 입력하세요>> ");
			String stuNo = ScannerUtil.nextLine();
			if(cancel(stuNo)) {
				break;
			}
			StudentVO selectOneStudent = studentController.selectOneStudent(new StudentVO(stuNo));
			System.out.println("현재 선택된 학생");
			System.out.println(StudentVO.columnString());
			System.out.println(selectOneStudent);
			System.out.println("변경할 학생정보를 입력하세요.");
			System.out.println("변경을 원하지 않는 항목은 0을 입력하세요.");
			List<String> afterUpdate = new ArrayList<>();
			System.out.print("변경할 학생명를 입력하세요>> ");
			afterUpdate.add(ScannerUtil.nextLine());
			System.out.print("변경할 E-mail을 입력하세요>> ");
			afterUpdate.add(ScannerUtil.nextLine());
			System.out.print("변경할 전화번호를 입력하세요>> ");
			afterUpdate.add(ScannerUtil.nextLine());
			System.out.print("변경할 학년을 입력하세요>> ");
			afterUpdate.add(ScannerUtil.nextLine());
			System.out.print("변경할 학적상태를 입력하세요>>");
			afterUpdate.add(ScannerUtil.nextLine());
			departmentList(depController);
			System.out.print("변경할 학과번호를 입력하세요>> ");
			afterUpdate.add(ScannerUtil.nextLine());
			System.out.print("변경할 생년월일을 입력하세요(예: 950102)>> ");
			afterUpdate.add(ScannerUtil.nextLine());
			
			List<String> beforeUpdate = selectOneStudent.getUpdateInfo();
			for(int i=0; i<afterUpdate.size(); i++) {
				if(afterUpdate.get(i).equals("0")) {
					afterUpdate.set(i, beforeUpdate.get(i));
				}
			}																	//	afterUpdate.get(7)은 학과명 출력을 위한 데이터삽입
			StudentVO updateVO = new StudentVO(stuNo,  afterUpdate.get(0), afterUpdate.get(1), afterUpdate.get(2),
							afterUpdate.get(3), afterUpdate.get(4), afterUpdate.get(5),afterUpdate.get(6));
			System.out.println(StudentVO.columnString());
			System.out.println(updateVO.updateToString());
			System.out.print("정보를 변경하시겠습니까? (y or n) >>");
			String yesOrNo = ScannerUtil.nextLine();
			if(yesOrNo.equalsIgnoreCase("y")) {
				int updateStudent = studentController.updateStudent(updateVO);
				if (updateStudent == 1) {
					System.out.println("학생이 수정되었습니다.");
					break;
				} else {
					System.out.println("유효하지 않은 입력입니다.");
					System.out.println("입력한 정보를 확인해주세요.");
				}
			}else {
				System.out.println("수정을 취소합니다.");
				System.out.println();
				break;
			}
		}
		return AdminMenu.STUDENT_MANAGEMENT;
	}
	
	public AdminMenu studentDelete(StudentController studentController) {
		while(true) {
			System.out.print(AdminMenu.STUDENT_DELETE.getMenuString());
			studentList(studentController);
			System.out.println("삭제를 취소하려면 학생번호에 0을 입력하세요.");
			System.out.print("삭제할 학생의 학생번호를 입력하세요>> ");
			String stuNo = ScannerUtil.nextLine();
			if(cancel(stuNo)) {
				System.out.println("삭제를 취소합니다.");
				break;
			}
			StudentVO studentVO = studentController.selectOneStudent(new StudentVO(stuNo));
			System.out.println(studentVO);
			System.out.print("위 학생을 삭제하시겠습니까?(y or n) >>");
			String yesOrNo = ScannerUtil.nextLine();
			if(yesOrNo.equalsIgnoreCase("y")) {
				int deleteStudent = studentController.deleteStudent(studentVO);
				if(deleteStudent ==1) {
					System.out.println("학생이 삭제되었습니다.");
					break;
				} else {
					System.out.println("유효하지 않은 입력입니다.");
					System.out.println("입력한 정보를 확인해주세요.");
				}
			} else {
				System.out.println("삭제를 취소합니다.");
				System.out.println();
				break;
			}
		}
		return AdminMenu.STUDENT_MANAGEMENT;
	}
	
	public AdminMenu professorList(ProfessorController professorController) {
		System.out.println(AdminMenu.PROFESSOR_LIST.getMenuString());
		List<ProfessorVO> list = professorController.selectProfessor();
		System.out.println(ProfessorVO.columnString());
		for (ProfessorVO vo : list) {
			System.out.println(vo);
		}
		System.out.println();
		return AdminMenu.PROFESSOR_MANAGEMENT;
	}
	
	public AdminMenu professorInsert(ProfessorController professorController, DepartMentController depController) {
		while (true) {
			System.out.print(AdminMenu.PROFESSOR_INSERT.getMenuString());
			professorList(professorController);
			System.out.println("입력을 취소하려면 교수명에 0을 입력하세요.");
			System.out.print("이름을 입력하세요>>");
			String pfNm = ScannerUtil.nextLine();
			if (cancel(pfNm)) {
				break;
			}
			System.out.print("전화번호를 입력하세요>>");
			String pfPneNo = ScannerUtil.nextLine();
			System.out.print("E-mail을 입력하세요>>");
			String pfEm = ScannerUtil.nextLine();
			departmentList(depController);
			System.out.print("학과번호를 입력하세요>>");
			String pfDep = ScannerUtil.nextLine();
			System.out.print("생년월일을 입력하세요(예: 950102)>>");
			String pfBir = ScannerUtil.nextLine();
			int insertProfessor = professorController
					.insertProfessor(new ProfessorVO( pfNm, pfPneNo, pfEm, pfDep, pfBir));
			if (insertProfessor == 1) {
				System.out.println("\n교수가 등록되었습니다.");
				break;
			} else {
				System.out.println("유효하지 않은 입력입니다.");
				System.out.println("입력한 정보를 확인해주세요.");
			}
		}
		return AdminMenu.PROFESSOR_MANAGEMENT;
	}


	public AdminMenu professorUpdate(ProfessorController professorController, DepartMentController depController) {
		System.out.print(AdminMenu.PROFESSOR_UPDATE.getMenuString());
		while(true) {
			professorList(professorController);
			System.out.println("수정을 취소하려면 교수번호에 0을 입력하세요.");
			System.out.print("정보 변경을 원하는 교수의 교수번호를 입력하세요>> ");
			String proNo = ScannerUtil.nextLine();
			if(cancel(proNo)) {
				break;
			}
			ProfessorVO selectOneProfessor = professorController.selectOneProfessor(new ProfessorVO(proNo));
			System.out.println();
			System.out.println("현재 선택된 교수");
			System.out.println(ProfessorVO.columnString());
			System.out.println(selectOneProfessor);
			System.out.println("변경할 교수정보를 입력하세요.");
			System.out.println("변경을 원하지 않는 항목은 0을 입력하세요.");
			System.out.println();
			List<String> afterUpdate = new ArrayList<>();
			
			System.out.print("변경할 교수명를 입력하세요>> ");
			afterUpdate.add(ScannerUtil.nextLine());
			System.out.print("변경할 전화번호를 입력하세요>> ");
			afterUpdate.add(ScannerUtil.nextLine());
			System.out.print("변경할 E-mail을 입력하세요>> ");
			afterUpdate.add(ScannerUtil.nextLine());
			departmentList(depController);
			System.out.print("변경할 학과번호를 입력하세요>> ");
			afterUpdate.add(ScannerUtil.nextLine());
			System.out.print("변경할 생년월일을 입력하세요>> ");
			afterUpdate.add(ScannerUtil.nextLine());
			
			List<String> beforeUpdate = selectOneProfessor.getUpdateInfo();
			for(int i=0; i<afterUpdate.size(); i++) {
				if(afterUpdate.get(i).equals("0")) {
					afterUpdate.set(i, beforeUpdate.get(i));
				}
			}
			ProfessorVO updateVO = new ProfessorVO(proNo, afterUpdate.get(0), afterUpdate.get(1), afterUpdate.get(2),
							afterUpdate.get(3), afterUpdate.get(4));
			System.out.println(ProfessorVO.columnString());
			System.out.println(updateVO.updateToString());
			System.out.print("정보를 변경하시겠습니까? (y or n) >>");
			String yesOrNo = ScannerUtil.nextLine();
			if(yesOrNo.equalsIgnoreCase("y")) {
				int updateProfessor = professorController.updateProfessor(updateVO);
				if (updateProfessor == 1) {
					System.out.println("교수가 수정되었습니다.");
					break;
				} else {
					System.out.println("유효하지 않은 입력입니다.");
					System.out.println("입력한 정보를 확인해주세요.");
				}
			} else {
				System.out.println("수정을 취소합니다.");
				System.out.println();
				break;
			}
		}
		return AdminMenu.PROFESSOR_MANAGEMENT;
	}

	public AdminMenu professorDelete(ProfessorController professorController) {
		while(true) {
			System.out.print(AdminMenu.PROFESSOR_DELETE.getMenuString());
			professorList(professorController);
			System.out.println("삭제를 취소하려면 교수번호에 0을 입력하세요.");
			System.out.print("삭제할 교수의 교수번호를 입력하세요>> ");
			String proNo = ScannerUtil.nextLine();
			if(cancel(proNo)) {
				System.out.println("삭제를 취소합니다.");
				break;
			}
			ProfessorVO professorVO = professorController.selectOneProfessor(new ProfessorVO(proNo));
			System.out.println(professorVO);
			System.out.print("위 교수를 삭제하시겠습니까?(y or n) >>");
			String yesOrNo = ScannerUtil.nextLine();
			if(yesOrNo.equalsIgnoreCase("y")) {
				int deleteProfessor = professorController.deleteProfessor(professorVO);
				if(deleteProfessor ==1) {
					System.out.println("교수가 삭제되었습니다.");
					break;
				} else {
					System.out.println("유효하지 않은 입력입니다.");
					System.out.println("입력한 정보를 확인해주세요.");
				}
			}else {
				System.out.println("삭제를 취소합니다.");
				System.out.println();
				break;
			}
		}
		return AdminMenu.PROFESSOR_MANAGEMENT;
	}


	public AdminMenu lectureList(LectureController lectureController) {
		System.out.println(AdminMenu.LECTURE_LIST.getMenuString());
		List<LectureVO> list = lectureController.selectLecture();
		System.out.println(LectureVO.columnLecture());
		for (LectureVO vo : list) {
			System.out.println(vo.listToString());
		}
		System.out.println();
		return AdminMenu.LECTURE_MANAGEMENT;
	}

	public AdminMenu lectureInsert(LectureController lectureController, DepartMentController depController,
									SubjectController subController) {
		while (true) {
			System.out.print(AdminMenu.LECTURE_INSERT.getMenuString());
			lectureList(lectureController);
			System.out.println("입력을 취소하려면 강의번호에 0을 입력하세요.");
			System.out.print("강의번호를 입력하세요(예: 1)>>");
			String ltcNo = ScannerUtil.nextLine();
			if (cancel(ltcNo)) {
				break;
			}
			subjectList(subController);
			System.out.print("과목번호를 입력하세요>>");
			String lecSub = ScannerUtil.nextLine();
			departmentList(depController);
			System.out.print("학과번호를 입력하세요>>");
			String lecDep = ScannerUtil.nextLine();
			System.out.print("연도를 입력하세요>>");
			String lecYr = ScannerUtil.nextLine();
			System.out.print("학기를 입력하세요>>");
			String lecSem = ScannerUtil.nextLine();
			System.out.print("강의시간을 입력하세요(예: AM/PM)>>");
			String lecTm = ScannerUtil.nextLine();
			System.out.print("강의요일을 입력하세요(예: 월)>>");
			String lecWk = ScannerUtil.nextLine();
			int insertStudent = lectureController
					.LectureInsert(new LectureVO(ltcNo, lecYr, lecSem, lecSub, lecDep, lecTm, lecWk));
			if (insertStudent == 1) {
				System.out.println("\n강의가 개설되었습니다.");
				break;
			} else {
				System.out.println("유효하지 않은 입력입니다.");
				System.out.println("입력한 정보를 확인해주세요.");
			}
		}
		return AdminMenu.LECTURE_MANAGEMENT;
	}
	
	public AdminMenu lectureUpdate(LectureController lectureController,SubjectController subController,
			DepartMentController depController) {
		System.out.println(AdminMenu.LECTURE_UPDATE.getMenuString());
		while(true) {
			lectureList(lectureController);
			System.out.println("수정을 취소하려면 강의번호에 0을 입력하세요.");
			System.out.print("정보 변경을 원하는 강의의 강의번호를 입력하세요>> ");
			String lecNo = ScannerUtil.nextLine();
			if(cancel(lecNo)) {
				break;
			}
			LectureVO selectOneLecture = lectureController.selectOneLecture(new LectureVO(lecNo));
			System.out.println();
			System.out.println("현재 선택된 강의");
			System.out.println(LectureVO.columnLecture());
			System.out.println(selectOneLecture.listToString());
			System.out.println("변경할 강의정보를 입력하세요.");
			System.out.println("변경을 원하지 않는 항목은 0을 입력하세요.");
			List<String> afterUpdate = new ArrayList<>();
			System.out.print("변경할 강의 연도를 입력하세요>>");
			afterUpdate.add(ScannerUtil.nextLine());
			System.out.print("변경할 강의 학기를 입력하세요>>");
			afterUpdate.add(ScannerUtil.nextLine());
			subjectList(subController);
			System.out.print("변경할 교과목번호를 입력하세요>>");
			afterUpdate.add(ScannerUtil.nextLine());
			departmentList(depController);
			System.out.print("변경할 개설학과를 입력하세요>>");
			afterUpdate.add(ScannerUtil.nextLine());
			System.out.print("변경할 강의 시간을 입력해주세요.(예: AM)>>");
			afterUpdate.add(ScannerUtil.nextLine());
			System.out.print("변경할 강의 요일을 입력해주세요.(예: 월)>>");
			afterUpdate.add(ScannerUtil.nextLine());
			List<String> beforeUpdate = selectOneLecture.getUpdateInfo();
			for(int i=0; i<afterUpdate.size(); i++) {
				if(afterUpdate.get(i).equals("0")) {
					afterUpdate.set(i, beforeUpdate.get(i));
				}
			}
			LectureVO updateVO = new LectureVO(lecNo, afterUpdate.get(0), afterUpdate.get(1), afterUpdate.get(2),
							afterUpdate.get(3), afterUpdate.get(4), afterUpdate.get(5));
			System.out.println(LectureVO.columnLecture());
			System.out.println(updateVO.updateToString());
			System.out.print("정보를 변경하시겠습니까? (y or n) >>");
			String yesOrNo = ScannerUtil.nextLine();
			if(yesOrNo.equalsIgnoreCase("y")) {
				int updateLecture = lectureController.updateLecture(updateVO);
				if (updateLecture == 1) {
					System.out.println("강의가 수정되었습니다.");
					break;
				} else {
					System.out.println("유효하지 않은 입력입니다.");
					System.out.println("입력한 정보를 확인해주세요.");
				}
			} else {
				System.out.println("수정을 취소합니다.");
				System.out.println();
				break;
			}
		}
		return AdminMenu.LECTURE_MANAGEMENT;
	}

	public AdminMenu subjectList(SubjectController subController) {
		System.out.println(AdminMenu.SUBJECT_LIST.getMenuString());
		System.out.println(SubjectVO.columnString());
		List<SubjectVO> list = subController.selectSub();
		for (SubjectVO vo : list) {
			System.out.println(vo);
		}
		System.out.println();
		return AdminMenu.SUBJECT_MANAGEMENT;
	}

	public AdminMenu subjectInsert(SubjectController subController,ProfessorController professorController,
									RoomController roomController) {
		while (true) {
			System.out.print(AdminMenu.SUBJECT_INSERT.getMenuString());
			subjectList(subController);
			System.out.println("입력을 취소하려면 과목번호에 0을 입력하세요.");
			System.out.print("과목번호를 입력하세요(예: 1)>>");
			String subNo = ScannerUtil.nextLine();
			if (cancel(subNo)) {
				break;
			}
			System.out.print("과목명을 입력하세요>>");
			String subNm = ScannerUtil.nextLine();
			System.out.print("이수구분를 입력하세요(예:실습)>>");
			String comDiv = ScannerUtil.nextLine();
			System.out.print("학점을 입력하세요>>(예: 3)");
			String subCre = ScannerUtil.nextLine();
			professorList(professorController);
			System.out.print("교수번호를 입력하세요>>");
			String subPro = ScannerUtil.nextLine();
			roomList(roomController);
			System.out.print("강의실번호를 입력하세요>>");
			String subRm = ScannerUtil.nextLine();
			int insertStudent = subController.insertSub(new SubjectVO(subNo, subNm, comDiv, subCre, subPro, subRm));
			if (insertStudent == 1) {
				System.out.println("\n교과목이 등록되었습니다.");
				break;
			} else {
				System.out.println("유효하지 않은 입력입니다.");
				System.out.println("입력한 정보를 확인해주세요.");
			}
		}
		return AdminMenu.SUBJECT_MANAGEMENT;
	}

	public AdminMenu subjectUpdate(SubjectController subController,ProfessorController professorController,
									RoomController roomController) {
		System.out.println(AdminMenu.SUBJECT_UPDATE.getMenuString());
		while(true) {
			subjectList(subController);
			System.out.println("수정을 취소하려면 과목번호에 0을 입력하세요.");
			System.out.print("정보 변경을 원하는 과목의 과목번호를 입력하세요>> ");
			String subNo = ScannerUtil.nextLine();
			if(cancel(subNo)) {
				break;
			}
			SubjectVO selectOneSub = subController.selectOneSub(new SubjectVO(subNo));
			System.out.println();
			System.out.println("현재 선택된 과목");
			System.out.println(SubjectVO.columnString());
			System.out.println(selectOneSub);
			System.out.println("변경할 과목정보를 입력하세요.");
			System.out.println("변경을 원하지 않는 항목은 0을 입력하세요.");
			List<String> afterUpdate = new ArrayList<>();
			System.out.print("변경할 과목명을 입력하세요>>");
			afterUpdate.add(ScannerUtil.nextLine());
			System.out.print("변경할 이수구분를 입력하세요(예:실습)>>");
			afterUpdate.add(ScannerUtil.nextLine());
			System.out.print("변경할 학점을 입력하세요>>(예: 3)");
			afterUpdate.add(ScannerUtil.nextLine());
			professorList(professorController);
			System.out.print("변경할 교수번호를 입력하세요>>");
			afterUpdate.add(ScannerUtil.nextLine());
			roomList(roomController);
			System.out.print("변경할 강의실번호를 입력하세요>>");
			afterUpdate.add(ScannerUtil.nextLine());
			List<String> beforeUpdate = selectOneSub.getUpdateInfo();
			for(int i=0; i<afterUpdate.size(); i++) {
				if(afterUpdate.get(i).equals("0")) {
					afterUpdate.set(i, beforeUpdate.get(i));
				}
			}
			SubjectVO updateVO = new SubjectVO(subNo, afterUpdate.get(0), afterUpdate.get(1), afterUpdate.get(2),
								afterUpdate.get(3), afterUpdate.get(4));
			System.out.println(SubjectVO.updateColumnString());
			System.out.println(updateVO.updateToString());
			System.out.print("정보를 변경하시겠습니까? (y or n) >>");
			String yesOrNo = ScannerUtil.nextLine();
			if(yesOrNo.equalsIgnoreCase("y")) {
				int updateStudent = subController
						.updateSub(updateVO);
				if (updateStudent == 1) {
					System.out.println("과목이 수정되었습니다.");
					break;
				} else {
					System.out.println("유효하지 않은 입력입니다.");
					System.out.println("입력한 정보를 확인해주세요.");
				}
			}else {
				System.out.println("수정을 취소합니다.");
				System.out.println();
				break;
			}
		}
		return AdminMenu.SUBJECT_MANAGEMENT;
	}
	
	public AdminMenu departmentList(DepartMentController depController) {
		System.out.println(AdminMenu.DEPARTMENT_LIST.getMenuString());
		System.out.println(DepartMentVO.columnString());
		List<DepartMentVO> list = depController.selectDepartment();
		for (DepartMentVO vo : list) {
			System.out.println(vo);
		}
		System.out.println();
		return AdminMenu.DEPARTMENT_MANAGEMENT;
	}
	
	public AdminMenu departmentInsert(DepartMentController depController) {
		while(true) {
			System.out.println(AdminMenu.DEPARTMENT_INSERT.getMenuString());
			departmentList(depController);
			System.out.println("입력을 취소하려면 학과번호에 0을 입력하세요.");
			System.out.print("학과번호를 입력하세요>>");
			String depNo = ScannerUtil.nextLine();
			if (cancel(depNo)) {
				break;
			}
			System.out.print("학과명을 입력하세요>>");
			String depNm = ScannerUtil.nextLine();
			System.out.print("전화번호를 입력하세요>>");
			String depPne = ScannerUtil.nextLine();
			int insertDepartment = depController.insertDepartment(new DepartMentVO(depNo,depNm,depPne));
			if(insertDepartment == 1) {
				System.out.println("\n학과가 등록되었습니다.");
				break;
			} else {
				System.out.println("유효하지 않은 입력입니다.");
				System.out.println("입력한 정보를 확인해주세요.");
			}
		}
		return AdminMenu.DEPARTMENT_MANAGEMENT;
	}
	
	public AdminMenu departmentUpdate(DepartMentController depController) {
		System.out.println(AdminMenu.DEPARTMENT_UPDATE.getMenuString());
		while(true) {
			departmentList(depController);
			System.out.println("수정을 취소하려면 학과번호에 0을 입력하세요.");
			System.out.print("정보 변경을 원하는 학과의 학과번호를 입력하세요>> ");
			String depNo = ScannerUtil.nextLine();
			if(cancel(depNo)) {
				break;
			}
			DepartMentVO selectOneDepartment = depController.selectOneDepartment(new DepartMentVO(depNo));
			System.out.println();
			System.out.println("현재 선택된 학과");
			System.out.println(DepartMentVO.columnString());
			System.out.println(selectOneDepartment);
			System.out.println("변경할 학과정보를 입력하세요.");
			System.out.println("변경을 원하지 않는 항목은 0을 입력하세요.");
			List<String> afterUpdate = new ArrayList<>();
			System.out.print("변경할 학과명를 입력하세요>> ");
			afterUpdate.add(ScannerUtil.nextLine());
			System.out.print("변경할 전화번호를 입력하세요>> ");
			afterUpdate.add(ScannerUtil.nextLine());
			
			List<String> beforeUpdate = selectOneDepartment.getUpdateInfo();
			for(int i=0; i<afterUpdate.size(); i++) {
				if(afterUpdate.get(i).equals("0")) {
					afterUpdate.set(i, beforeUpdate.get(i));
				}
			}
			DepartMentVO updateVO = new DepartMentVO(depNo, afterUpdate.get(0), afterUpdate.get(1));
			System.out.println(DepartMentVO.columnString());
			System.out.println(updateVO);
			System.out.print("정보를 변경하시겠습니까? (y or n) >>");
			String yesOrNo = ScannerUtil.nextLine();
			if(yesOrNo.equalsIgnoreCase("y")) {
				int updateStudent = depController
						.updateDepartment(updateVO);
				if (updateStudent == 1) {
					System.out.println("학과가 수정되었습니다.");
					break;
				} else {
					System.out.println("유효하지 않은 입력입니다.");
					System.out.println("입력한 정보를 확인해주세요.");
				}
			}else {
				System.out.println("수정을 취소합니다.");
				System.out.println();
				break;
			}
		}
		return AdminMenu.DEPARTMENT_MANAGEMENT;
	}
	
	public AdminMenu departmentDelete(DepartMentController depController) {
		while(true) {
			System.out.println(AdminMenu.DEPARTMENT_DELETE.getMenuString());
			departmentList(depController);
			System.out.println("삭제를 취소하려면 학과번호에 0을 입력하세요.");
			System.out.print("삭제할 학과의 학과번호를 입력하세요>> ");
			String depNo = ScannerUtil.nextLine();
			if(cancel(depNo)) {
				System.out.println("삭제를 취소합니다.");
				break;
			}
			DepartMentVO departMentVO = depController.selectOneDepartment(new DepartMentVO(depNo));
			System.out.println(departMentVO);
			System.out.print("위 학과를 삭제하시겠습니까?(y or n) >>");
			String yesOrNo = ScannerUtil.nextLine();
			if(yesOrNo.equalsIgnoreCase("y")) {
				int deleteDepartment = depController.deleteDepartment(new DepartMentVO(depNo));
				if(deleteDepartment ==1) {
					System.out.println("학과가 삭제되었습니다.");
					break;
				} else {
					System.out.println("유효하지 않은 입력입니다.");
					System.out.println("학과에 소속된 학생, 교수 또는 강의의 개설학과가 존재하면 삭제할 수 없습니다.");
					System.out.println("학과에 소속된 학생, 교수 또는 강의의 개설학과를 수정 후 삭제할 수 있습니다.");
				}
			}else {
				System.out.println("삭제를 취소합니다.");
				System.out.println();
				break;
			}
		}
		return AdminMenu.DEPARTMENT_MANAGEMENT;
	}
	
	public AdminMenu roomList(RoomController roomController) {
		System.out.println(AdminMenu.ROOM_LIST.getMenuString());
		System.out.println(RoomVO.columnString());
		List<RoomVO> list = roomController.selectRoom();
		System.out.println();
		for(RoomVO vo : list) {
			System.out.println(vo);
		}
		System.out.println();
		return AdminMenu.ROOM_MANAGEMENT;
	}
	
	public AdminMenu roomInsert(RoomController roomController) {
		while(true) {
			System.out.println(AdminMenu.ROOM_INSERT.getMenuString());
			roomList(roomController);
			System.out.println("입력을 취소하려면 강의실번호에 0을 입력하세요.");
			System.out.print("강의실번호를 입력하세요>>");
			String rmNo = ScannerUtil.nextLine();
			if (cancel(rmNo)) {
				break;
			}
			System.out.print("강의실명을 입력하세요>>");
			String rmNm = ScannerUtil.nextLine();
			int insertRoom = roomController.insertRoom(new RoomVO(rmNo, rmNm));
			if(insertRoom == 1) {
				System.out.println("\n강의실이 등록되었습니다.");
				break;
			} else {
				System.out.println("유효하지 않은 입력입니다.");
				System.out.println("입력한 정보를 확인해주세요.");
			}
		}
		return AdminMenu.ROOM_MANAGEMENT;
	}
	public AdminMenu roomUpdate(RoomController roomController) {
		System.out.println(AdminMenu.ROOM_MANAGEMENT.getMenuString());
		while(true) {
			roomList(roomController);
			System.out.println("수정을 취소하려면 강의실번호에 0을 입력하세요.");
			System.out.print("정보 변경을 원하는 강의실의 강의실번호를 입력하세요>> ");
			String rmNo = ScannerUtil.nextLine();
			if(cancel(rmNo)) {
				break;
			}
			RoomVO selectOneRoom = roomController.selectOneRoom(new RoomVO(rmNo));
			System.out.println("현재 선택된 강의실");
			System.out.println(RoomVO.columnString());
			System.out.println(selectOneRoom);
			List<String> afterUpdate = new ArrayList<>();
			System.out.println("변경할 강의실정보를 입력하세요.");
			System.out.println("변경을 원하지 않는 항목은 0을 입력하세요.");
			System.out.print("변경할 강의실명을 입력하세요>> ");
			afterUpdate.add(ScannerUtil.nextLine());
			
			List<String> beforeUpdate = selectOneRoom.getUpdateInfo();
			for(int i=0; i<afterUpdate.size(); i++) {
				if(afterUpdate.get(i).equals("0")) {
					afterUpdate.set(i, beforeUpdate.get(i));
				}
			}
			RoomVO updateVO = new RoomVO(rmNo,afterUpdate.get(0));
			System.out.println(RoomVO.columnString());
			System.out.println(updateVO);
			System.out.print("정보를 변경하시겠습니까? (y or n) >>");
			String yesOrNo = ScannerUtil.nextLine();
			if(yesOrNo.equalsIgnoreCase("y")) {
				int updateRoom = roomController.updateRoom(updateVO);
				if (updateRoom == 1) {
					System.out.println("강의실이 수정되었습니다.");
					break;
				} else {
					System.out.println("유효하지 않은 입력입니다.");
					System.out.println("입력한 정보를 확인해주세요.");
				}
			} else {
				System.out.println("수정을 취소합니다.");
				System.out.println();
				break;
			}
		}
		return AdminMenu.ROOM_MANAGEMENT;
	}
	
	public AdminMenu roomDelete(RoomController roomController) {
		while(true) {
			System.out.println(AdminMenu.ROOM_DELETE.getMenuString());
			roomList(roomController);
			System.out.println("삭제를 취소하려면 강의실번호에 0을 입력하세요.");
			System.out.print("삭제할 강의실의 강의실번호를 입력하세요>> ");
			String rmNo = ScannerUtil.nextLine();
			if(cancel(rmNo)) {
				System.out.println("삭제를 취소합니다.");
				break;
			}
			RoomVO roomVO = roomController.selectOneRoom(new RoomVO(rmNo));
			System.out.println(roomVO);
			System.out.print("위 강의실을 삭제하시겠습니까?(y or n) >>");
			String yesOrNo = ScannerUtil.nextLine();
			if(yesOrNo.equalsIgnoreCase("y")) {
				int deleteRoom = roomController.deleteRoom(new RoomVO(rmNo));
				if(deleteRoom == 1) {
					System.out.println("강의실이 삭제되었습니다.");
					break;
				} else {
					System.out.println("유효하지 않은 입력입니다.");
					System.out.println("입력한 정보를 확인해주세요.");
				}
			}else {
				System.out.println("삭제를 취소합니다.");
				System.out.println();
				break;
			}
		}
		return AdminMenu.ROOM_MANAGEMENT;
	}
	
}
