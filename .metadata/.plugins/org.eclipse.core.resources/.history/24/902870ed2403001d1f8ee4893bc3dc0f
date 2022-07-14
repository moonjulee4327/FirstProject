package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
	public int select(StudentVO vo) {
		try {
			DriverManager.registerDriver(new OracleDriver());
			
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@1.212.157.146:1521:xe", "StudentPoral", "java");
			StringBuilder builder = new StringBuilder();
			builder.append("");
			
			String sql = builder.toString();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setObject(0, statement);
			
			ResultSet resultSet = statement.executeQuery();
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return 0;
		
	}
}
