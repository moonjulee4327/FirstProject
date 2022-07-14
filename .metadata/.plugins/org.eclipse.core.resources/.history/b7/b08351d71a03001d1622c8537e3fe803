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
	
	
	public int selectSign(SignVO vo) {
		try {
			DriverManager.registerDriver(new OracleDriver());
			
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@1.212.157.146:1521:xe", "StudentPoral", "java");
			
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT");
			builder.append("    stu_nm");
			builder.append("FROM");
			builder.append("    stu");
			builder.append("WHERE");
			builder.append("    stu_no = ? ");
			builder.append("    AND   TO_CHAR(stu_bir,'YYMMDD') = ? ");
			String sql = builder.toString();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setObject(1, vo.getId());
			statement.setObject(2, vo.getPw());	
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				System.out.println(resultSet.getString("stu_nm"));
				return 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return 0;
		
	}

}
