package sign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class SignDAO {
	private static SignDAO signDAO = new SignDAO();
	
	private SignDAO() {}
	
	public static SignDAO getInstance() {
		return signDAO;
	}
	
	
	public int studentSign(SignVO vo) {
		int result = 0;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
			
			StringBuilder builder = new StringBuilder();
			builder.append(" SELECT");
			builder.append("     stu_nm");
			builder.append(" FROM");
			builder.append("     stu");
			builder.append(" WHERE");
			builder.append("     stu_no = ? ");
			builder.append("     AND   TO_CHAR(stu_bir,'YYMMDD') = ? ");
			String sql = builder.toString();
			statement = connection.prepareStatement(sql);
			statement.setObject(1, vo.getId());
			statement.setObject(2, vo.getPw());	
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				System.out.print(resultSet.getString("stu_nm"));
				result = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	public int professorSign(SignVO vo) {
		int result = 0;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
			
			StringBuilder builder = new StringBuilder();
			builder.append(" SELECT");
			builder.append("     pro_nm");
			builder.append(" FROM");
			builder.append("     pro");
			builder.append(" WHERE");
			builder.append("     pro_no =?");
			builder.append("     AND   TO_CHAR(pro_bir,'YYMMDD') =?");
			String sql = builder.toString();
			statement = connection.prepareStatement(sql);
			statement.setObject(1, vo.getId());
			statement.setObject(2, vo.getPw());	
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				System.out.print(resultSet.getString("pro_nm"));
				result = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
}
