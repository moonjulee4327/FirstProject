package room;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import department.DepartMentVO;
import oracle.jdbc.driver.OracleDriver;

public class RoomDAO {
	//필드
	private static RoomDAO studentDAO = new RoomDAO();
	
	//생성자
	private RoomDAO() {}
	
	//메소드
	public static RoomDAO getInstance() {
		return studentDAO;
	}
	
	public List<RoomVO> selectRoom() throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
		Statement statement = connection.createStatement();
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT");
		builder.append("     rm_no,");
		builder.append("     rm_nm ");
		builder.append(" FROM");
		builder.append("     rm");
		builder.append(" ORDER BY ");
		builder.append(" 	 rm_no ");
		String sql = builder.toString();
		
		ResultSet resultSet = statement.executeQuery(sql);
		
		ArrayList<RoomVO> list = new ArrayList<>();
		while(resultSet.next()) {
			String rmNo = resultSet.getString("rm_no");
			String rmNm = resultSet.getString("rm_nm");
			list.add(new RoomVO(rmNo, rmNm));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
		
	}
	
	public RoomVO selectOneRoom(RoomVO vo) throws SQLException {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal",
				"java");
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT");
		builder.append("     rm_no,");
		builder.append("     rm_nm");
		builder.append(" FROM");
		builder.append("     rm");
		builder.append(" where  rm_no = ?");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, vo.getRmNo());
		ResultSet resultSet = statement.executeQuery();
		RoomVO result = null;
		if(resultSet.next()) {
			String rmNo = resultSet.getString("rm_no");
			String rmNm = resultSet.getString("rm_nm");
			result = new RoomVO(rmNo, rmNm);
		}
		
		resultSet.close();
		statement.close();
		connection.close();
		
		return result;
	}
	
	public int insertRoom(RoomVO vo) throws Exception{
		
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO rm (");
		builder.append("    rm_no,");
		builder.append("    rm_nm");
		builder.append(") VALUES (");
		builder.append("    ?,");
		builder.append("    ?");
		builder.append(")");

		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getRmNo());
		statement.setString(2, vo.getRmNm());
		
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		
		return executeUpdate;
	}
	public int updateRoom(RoomVO vo) throws Exception {

		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal",
				"java");
		StringBuilder builder = new StringBuilder();
		builder.append("  UPDATE rm     ");
		builder.append("      SET     ");
		builder.append("    rm_nm = ?");
		builder.append("  WHERE     ");
		builder.append("      rm_no = ?     ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, vo.getRmNm());
		statement.setObject(2, vo.getRmNo());

		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}

	public int deleteRoom(RoomVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal",
				"java");
		StringBuilder builder = new StringBuilder();
		builder.append("   DELETE FROM rm WHERE  ");
		builder.append("       rm_no = ?  ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, vo.getRmNo());
		int executeUpdate = statement.executeUpdate();

		statement.close();
		connection.close();
		return executeUpdate;

	}
	
}
