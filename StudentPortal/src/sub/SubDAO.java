package sub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

public class SubDAO {
	// 필드
	private static SubDAO subDAO = new SubDAO();
	List<SubVO> list = new ArrayList<>();

	// 생성자
	private SubDAO() {
	}

	public static SubDAO getInstance() {
		return subDAO;
	}
	//과목 조회
	public List<SubVO> selectSub() throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal",
				"java");
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT");
		builder.append("     sub_no,");
		builder.append("     sub_nm,");
		builder.append("     com_div,");
		builder.append("     cre,");
		builder.append("     sub_pro,");
		builder.append("     sub_rm");
		builder.append(" FROM");
		builder.append("     sub");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			int subNo = resultSet.getInt("sub_no");
			int cre = resultSet.getInt("cre");
			int subPro = resultSet.getInt("sub_pro");
			int subRm = resultSet.getInt("sub_rm");
			String subNm = resultSet.getString("sub_nm");
			String comDiv = resultSet.getString("com_div");
			list.add(new SubVO(subNo, cre, subPro, subRm, subNm, comDiv));
		}

		resultSet.close();
		statement.close();
		connection.close();
		return list;

	}
 

	// 과목 등록
	public int insertSub(SubVO vo) throws Exception {
		int executeUpdate = 0;

		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal",
				"java");
		StringBuilder builder = new StringBuilder();
		builder.append("  INSERT INTO sub (   ");
		builder.append("          sub_no,   ");
		builder.append("          sub_nm,   ");
		builder.append("          com_div,   ");
		builder.append("          cre,   ");
		builder.append("          sub_pro,   ");
		builder.append("          sub_rm   ");
		builder.append("      ) VALUES (   ");
		builder.append("          ?,   ");
		builder.append("          ?,   ");
		builder.append("          ?,   ");
		builder.append("          ?,   ");
		builder.append("          ?,   ");
		builder.append("          ?   ");
		builder.append("      )   ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, vo.getSubNo());
		statement.setObject(2, vo.getSubNm());
		statement.setObject(3, vo.getComDiv());
		statement.setObject(4, vo.getCre());
		statement.setObject(5, vo.getSubPro());
		statement.setObject(6, vo.getSubRm());

		executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();

		return executeUpdate;

	}
	
}
