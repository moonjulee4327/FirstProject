package Professor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

public class ProfessorDAO {
	private static ProfessorDAO professorDAO = new ProfessorDAO();
	List<ProfessorVO> list = new ArrayList<>();

	private ProfessorDAO() {
	} // 싱글톤

	public static ProfessorDAO getInstance() {
		return professorDAO;
	}

	public List<ProfessorVO> selectProfessor() throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal",
				"java");
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT");
		builder.append("     pro_no,");
		builder.append("     pro_dep,");
		builder.append("     pro_nm,");
		builder.append("     dep_nm,");
		builder.append("     pro_pne_no,");
		builder.append("     pro_em,");
		builder.append("     pro_bir");
		builder.append(" FROM");
		builder.append("     pro,");
		builder.append("     dep");
		builder.append(" WHERE");
		builder.append("     pro_dep = dep_no");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {

			String proNo = resultSet.getString("pro_no");
			String proDep = resultSet.getString("pro_dep");
			String proNm = resultSet.getString("pro_nm");
			String depNm = resultSet.getString("dep_nm");
			String proPneNo = resultSet.getString("pro_pne_no");
			String proEm = resultSet.getString("pro_em");
			String proBir = resultSet.getString("pro_bir");
			list.add(new ProfessorVO(proNo, proDep, proNm, depNm, proPneNo, proEm, proBir.substring(0, 9)));
		}

		resultSet.close();
		statement.close();
		connection.close();

		return list;

	}

	public int insertProfessor(ProfessorVO vo) throws Exception {
		int executeUpdate = 0;

		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal",
				"java");
		StringBuilder builder = new StringBuilder();
		builder.append("  INSERT INTO pro (");
		builder.append("         pro_no,");
		builder.append("         pro_nm,");
		builder.append("         pro_pne_no,");
		builder.append("         pro_em,");
		builder.append("         pro_dep,");
		builder.append("         pro_bir");
		builder.append("     ) VALUES (");
		builder.append("         ?,");
		builder.append("         ?,");
		builder.append("         ?,");
		builder.append("         ?,");
		builder.append("         ?,");
		builder.append("         ?");
		builder.append("     )");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, vo.getProNo());
		statement.setObject(2, vo.getProNm());
		statement.setObject(3, vo.getProPneNo());
		statement.setObject(4, vo.getProEm());
		statement.setObject(5, vo.getProDep());
		statement.setObject(6, vo.getProBir());

		executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();

		return executeUpdate;

	}

//	public int updateProfessor(ProfessorVO vo)  {
//		int executeUpdate = 0;
//		
//		try {
//			DriverManager.registerDriver(new OracleDriver());
//			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe",
//	"StudentPortal", "java");
//			StringBuilder builder = new StringBuilder();
//			builder.append("  ");
//			builder.append("  ");
//			builder.append("  ");
//			builder.append("  ");
//			builder.append("  ");
//			builder.append("  ");
//			builder.append("  ");
//			builder.append("  ");
//			builder.append("  ");
//			String sql = builder.toString();
//			PreparedStatement statement = connection.prepareStatement(sql);
//			
//			// insert, update, delete가 모두 executeUpdate()메소드를 호출
//			
//			
//			statement.close();
//			connection.close();
//			return executeUpdate;
//		} catch (SQLException e) {
////			e.printStackTrace();
//		}
//		return executeUpdate;
//	}

}
