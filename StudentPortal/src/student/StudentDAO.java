package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Professor.ProfessorVO;
import oracle.jdbc.driver.OracleDriver;

public class StudentDAO {
	//필드
	private static StudentDAO studentDAO = new StudentDAO();
	
	//생성자
	private StudentDAO() {}
	
	//메소드
	public static StudentDAO getInstance() {
		return studentDAO;
	}
	
	public List<StudentVO> selectStudent() throws Exception {
			DriverManager.registerDriver(new OracleDriver());
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
			Statement statement = connection.createStatement();
			StringBuilder builder = new StringBuilder();
			builder.append(" SELECT");
			builder.append("     stu_no,");
			builder.append("     stu_nm,");
			builder.append("     stu_em,");
			builder.append("     stu_pne_no,");
			builder.append("     stu_grd,");
			builder.append("     stu_acd_st,");
			builder.append("     stu_dep,");
			builder.append("     dep_nm,");
			builder.append("     TO_CHAR(stu_bir,'YYYY-MM-DD') bir");
			builder.append(" FROM");
			builder.append("     stu,");
			builder.append("     dep");
			builder.append(" WHERE");
			builder.append("     stu_dep = dep_no");
			builder.append(" ORDER BY ");
			builder.append(" 	 stu_no ");
			String sql = builder.toString();
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			ArrayList<StudentVO> list = new ArrayList<>();
			while(resultSet.next()) {
				String stuNo = resultSet.getString("stu_no");
				String stuNm = resultSet.getString("stu_nm");
				String stuEm = resultSet.getString("stu_em");
				String stuPneNo = resultSet.getString("stu_pne_no");
				String stuGrd = resultSet.getString("stu_grd");
				String stuAcdSt = resultSet.getString("stu_acd_st");
				String stu_dep = resultSet.getString("stu_dep");
				String dep_nm = resultSet.getString("dep_nm");
				String stuBir = resultSet.getString("bir");
				list.add(new StudentVO(stuNo, stuNm, stuEm, stuPneNo, stuGrd, stuAcdSt,stu_dep, dep_nm, stuBir));
			}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
		
	}
	public StudentVO selectOneStudent(StudentVO vo) throws SQLException {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT");
		builder.append("     stu_no,");
		builder.append("     stu_nm,");
		builder.append("     stu_em,");
		builder.append("     stu_pne_no,");
		builder.append("     stu_grd,");
		builder.append("     stu_acd_st,");
		builder.append("     stu_dep,");
		builder.append("     dep_nm,");
		builder.append("     TO_CHAR(stu_bir,'YYYY-MM-DD') bir");
		builder.append(" FROM");
		builder.append("     stu,");
		builder.append("     dep");
		builder.append(" WHERE");
		builder.append("     stu_dep = dep_no");
		builder.append(" and    stu_no = ?");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1,vo.getStuNo());
		ResultSet resultSet = statement.executeQuery();
		StudentVO studentVO = null;
		if(resultSet.next()) {
			String stuNo = resultSet.getString("stu_no");
			String stuNm = resultSet.getString("stu_nm");
			String stuEm = resultSet.getString("stu_em");
			String stuPneNo = resultSet.getString("stu_pne_no");
			String stuGrd = resultSet.getString("stu_grd");
			String stuAcdSt = resultSet.getString("stu_acd_st");
			String stu_dep = resultSet.getString("stu_dep");
			String dep_nm = resultSet.getString("dep_nm");
			String stuBir = resultSet.getString("bir");
			studentVO = new StudentVO(stuNo, stuNm, stuEm, stuPneNo, stuGrd, stuAcdSt, stu_dep, dep_nm, stuBir);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return studentVO;
	}
	public int insertStudent(StudentVO vo) throws Exception{
		
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("     INSERT INTO stu (");
		builder.append("         stu_no,");
		builder.append("         stu_nm,");
		builder.append("         stu_em,");
		builder.append("         stu_pne_no,");
		builder.append("         stu_grd,");
		builder.append("         stu_acd_st,");
		builder.append("         stu_dep,");
		builder.append("         stu_bir");
		builder.append("     ) VALUES (");
		builder.append("         EXTRACT(YEAR FROM SYSDATE) - ? + 1");
		builder.append("         || TRIM(TO_CHAR(?,'00') )");
		builder.append("         || (");
		builder.append("             select");
		builder.append("                 TRIM(TO_CHAR(nvl(MAX(substr(stu_no,7) ),0) + 1,'000') )");
		builder.append("             FROM");
		builder.append("                 stu");
		builder.append("             WHERE");
		builder.append("                 substr(stu_no,1,6) = EXTRACT(YEAR FROM SYSDATE) - ? + 1");
		builder.append("                 || TRIM(TO_CHAR(?,'00') )");
		builder.append("         ),");
		builder.append("         ?,");
		builder.append("         ?,");
		builder.append("         ?,");
		builder.append("         TO_CHAR(?,'00'),    ");
		builder.append("         '재학',");
		builder.append("         ?,      ");
		builder.append("         ?");
		builder.append("     )");
		

		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getStuGrd());
		statement.setObject(2,  Integer.valueOf(vo.getStuDep()));
		statement.setString(3, vo.getStuGrd());
		statement.setObject(4,  Integer.valueOf(vo.getStuDep()));
		statement.setString(5, vo.getStuNm());
		statement.setString(6, vo.getStuEm());
		statement.setString(7, vo.getStuPneNo());
		statement.setString(8, vo.getStuGrd());
		statement.setString(9, vo.getStuDep());
		statement.setString(10, vo.getStuBir());
		
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		
		return executeUpdate;
	}
	
	public int updateStudent(StudentVO vo) throws Exception {

		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal",
				"java");
		StringBuilder builder = new StringBuilder();
		builder.append("  UPDATE stu     ");
		builder.append("      SET     ");
		builder.append("          stu_nm = ?,     ");
		builder.append("          stu_em = ?,     ");
		builder.append("          stu_pne_no = ?,  ");
		builder.append("          stu_grd = ?,     ");
		builder.append("          stu_acd_st = ?,     ");
		builder.append("          stu_dep = ?,     ");
		builder.append("          stu_bir = substr(?,1,10)     ");
		builder.append("  WHERE     ");
		builder.append("      stu_no = ?     ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, vo.getStuNm());
		statement.setObject(2, vo.getStuEm());
		statement.setObject(3, vo.getStuPneNo());
		statement.setObject(4, vo.getStuGrd());
		statement.setObject(5, vo.getStuAcdSt());
		statement.setObject(6, vo.getStuDep());
		statement.setObject(7, vo.getStuBir());
		statement.setObject(8, vo.getStuNo());

		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}

	
	public int deleteStudent(StudentVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal",
				"java");
		StringBuilder builder = new StringBuilder();
		builder.append("   DELETE FROM stu WHERE  ");
		builder.append("       stu_no = ?  ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, vo.getStuNo());
		int executeUpdate = statement.executeUpdate();

		statement.close();
		connection.close();
		return executeUpdate;

	}
}
