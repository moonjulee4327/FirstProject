package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
			builder.append("     dep_nm,");
			builder.append("     stu_bir");
			builder.append(" FROM");
			builder.append("     stu,");
			builder.append("     dep");
			builder.append(" WHERE");
			builder.append("     stu_dep = dep_no");
			String sql = builder.toString();
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			ArrayList<StudentVO> list = new ArrayList<>();
			while(resultSet.next()) {
				int stuNo = resultSet.getInt("stu_no");
				String stuNm = resultSet.getString("stu_nm");
				String stuEm = resultSet.getString("stu_em");
				String stuPneNo = resultSet.getString("stu_pne_no");
				int stuGrd = resultSet.getInt("stu_grd");
				String stuAcdSt = resultSet.getString("stu_acd_st");
				String dep_nm = resultSet.getString("dep_nm");
				String stuBir = resultSet.getString("stu_bir");
				list.add(new StudentVO(stuNo, stuNm, stuEm, stuPneNo, stuGrd, stuAcdSt, dep_nm, stuBir));
			}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
		
	}
	
	public int insertStudent(StudentVO vo) throws Exception{
		
			DriverManager.registerDriver(new OracleDriver());
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
			StringBuilder builder = new StringBuilder();
			builder.append("INSERT INTO stu (");
			builder.append("    stu_no,");
			builder.append("    stu_nm,");
			builder.append("    stu_em,");
			builder.append("    stu_pne_no,");
			builder.append("    stu_grd,");
			builder.append("    stu_acd_st,");
			builder.append("    stu_dep,");
			builder.append("    stu_bir");
			builder.append(") VALUES (");
			builder.append("    ?,");
			builder.append("    ?,");
			builder.append("    ?,");
			builder.append("    ?,");
			builder.append("    ?,");
			builder.append("    ?,");
			builder.append("    ?,");
			builder.append("    ?");
			builder.append(")");

			String sql = builder.toString();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, vo.getStuNo());
			statement.setString(2, vo.getStuNm());
			statement.setString(3, vo.getStuEm());
			statement.setString(4, vo.getStuPneNo());
			statement.setInt(5, vo.getStuGrd());
			statement.setString(6, vo.getStuAcdSt());
			statement.setString(7, vo.getStuDep());
			statement.setString(8, vo.getStuBir());
			
			int executeUpdate = statement.executeUpdate();
			statement.close();
			connection.close();
			
			return executeUpdate;
	}
	
}
