package department;

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

public class DepartMentDAO {
	//필드
	private static DepartMentDAO studentDAO = new DepartMentDAO();
	
	//생성자
	private DepartMentDAO() {}
	
	//메소드
	public static DepartMentDAO getInstance() {
		return studentDAO;
	}
	
	public List<DepartMentVO> selectDepartment() throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
		Statement statement = connection.createStatement();
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT");
		builder.append("     dep_no,");
		builder.append("     dep_nm,");
		builder.append("     dep_pne");
		builder.append(" FROM");
		builder.append("     dep");
		builder.append(" ORDER BY ");
		builder.append(" 	 dep_no ");
		String sql = builder.toString();
		
		ResultSet resultSet = statement.executeQuery(sql);
		
		ArrayList<DepartMentVO> list = new ArrayList<>();
		while(resultSet.next()) {
			String depNo = resultSet.getString("dep_no");
			String depNm = resultSet.getString("dep_nm");
			String depPne = resultSet.getString("dep_pne");
			list.add(new DepartMentVO(depNo, depNm, depPne));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
		
	}
	
	public DepartMentVO selectOneDepartment(DepartMentVO vo) throws SQLException {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal",
				"java");
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT");
		builder.append("     dep_no,");
		builder.append("     dep_nm,");
		builder.append("     dep_pne");
		builder.append(" FROM");
		builder.append("     dep");
		builder.append(" where  dep_no = ?");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, vo.getDepNo());
		ResultSet resultSet = statement.executeQuery();
		DepartMentVO result = null;
		if(resultSet.next()) {
			String depNo = resultSet.getString("dep_no");
			String depNm = resultSet.getString("dep_nm");
			String depPne = resultSet.getString("dep_pne");
			result = new DepartMentVO(depNo, depNm, depPne);
		}
		
		resultSet.close();
		statement.close();
		connection.close();
		
		return result;
	}
	public int insertDepartment(DepartMentVO vo) throws Exception{
		
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO dep (");
		builder.append("    dep_no,");
		builder.append("    dep_nm,");
		builder.append("    dep_pne");
		builder.append(") VALUES (");
		builder.append("    ?,");
		builder.append("    ?,");
		builder.append("    ?");
		builder.append(")");

		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getDepNo());
		statement.setString(2, vo.getDepNm());
		statement.setString(3, vo.getDepPne());
		
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		
		return executeUpdate;
	}
	
	public int updateDepartment(DepartMentVO vo) throws Exception {

		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal",
				"java");
		StringBuilder builder = new StringBuilder();
		builder.append("  UPDATE dep     ");
		builder.append("      SET     ");
		builder.append("    dep_nm = ?,");
		builder.append("    dep_pne = ?");
		builder.append("  WHERE     ");
		builder.append("      dep_no = ?     ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, vo.getDepNm());
		statement.setObject(2, vo.getDepPne());
		statement.setObject(3, vo.getDepNo());

		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}

	public int deleteDepartment(DepartMentVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal",
				"java");
		StringBuilder builder = new StringBuilder();
		builder.append("   DELETE FROM dep WHERE  ");
		builder.append("       dep_no = ?  ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, vo.getDepNo());
		int executeUpdate = statement.executeUpdate();

		statement.close();
		connection.close();
		return executeUpdate;

	}
	
}
