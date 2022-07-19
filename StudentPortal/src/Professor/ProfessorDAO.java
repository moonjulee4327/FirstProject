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
		builder.append("     pro_nm,");
		builder.append("     pro_pne_no,");
		builder.append("     pro_em,");
		builder.append("     dep_nm,");
		builder.append("     pro_dep,");
		builder.append("     TO_CHAR(pro_bir,'YYYY-MM-DD') bir");
		builder.append(" FROM");
		builder.append("     pro,");
		builder.append("     dep");
		builder.append(" WHERE");
		builder.append("     pro_dep = dep_no");
		builder.append(" ORDER BY ");
		builder.append(" 	 pro_no ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		List<ProfessorVO> list = new ArrayList<>();
		while (resultSet.next()) {

			String proNo = resultSet.getString("pro_no");
			String proNm = resultSet.getString("pro_nm");
			String proPneNo = resultSet.getString("pro_pne_no");
			String proEm = resultSet.getString("pro_em");
			String depNm = resultSet.getString("dep_nm");
			String proDep = resultSet.getString("pro_dep");
			String proBir = resultSet.getString("bir");
			list.add(new ProfessorVO(proNo, proNm, proEm, proPneNo,depNm, proDep, proBir));
		}

		resultSet.close();
		statement.close();
		connection.close();

		return list;

	}
	public ProfessorVO selectOneProfessor(ProfessorVO vo) throws SQLException {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal",
				"java");
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT");
		builder.append("     pro_no,");
		builder.append("     pro_nm,");
		builder.append("     pro_pne_no,");
		builder.append("     pro_em,");
		builder.append("     dep_nm,");
		builder.append("     pro_dep,");
		builder.append("     TO_CHAR(pro_bir,'YYYY-MM-DD') bir");
		builder.append(" FROM");
		builder.append("     pro,");
		builder.append("     dep");
		builder.append(" WHERE");
		builder.append("     pro_dep = dep_no");
		builder.append(" and    pro_no = ?");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, vo.getProNo());
		ResultSet resultSet = statement.executeQuery();
		ProfessorVO result = null;
		if(resultSet.next()) {
			String proNo = resultSet.getString("pro_no");
			String proNm = resultSet.getString("pro_nm");
			String proPneNo = resultSet.getString("pro_pne_no");
			String proEm = resultSet.getString("pro_em");
			String depNm = resultSet.getString("dep_nm");
			String proDep = resultSet.getString("pro_dep");
			String proBir = resultSet.getString("bir");
			result = new ProfessorVO(proNo, proNm, proEm, proPneNo, depNm, proDep, proBir);
		}

		resultSet.close();
		statement.close();
		connection.close();

		return result;
	}

	// 교수 추가
	public int insertProfessor(ProfessorVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal",
				"java");
		StringBuilder builder = new StringBuilder();
		builder.append(" INSERT");
		builder.append("     INTO pro");
		builder.append(" ( ");
		builder.append("        pro_no,  ");
		builder.append("        pro_nm,  ");
		builder.append("        pro_pne_no,");
		builder.append("        pro_em,  ");
		builder.append("        pro_dep, ");
		builder.append("        pro_bir  ");
		builder.append("    ) VALUES (   ");
		builder.append("        to_char( SYSDATe,'YY')                           ");
		builder.append("  || TRIM(TO_CHAR(?,'00') )                                    ");
		builder.append("  || (                                                         ");
		builder.append("      select                                                   ");
		builder.append("          TRIM(TO_CHAR(nvl(MAX(substr(pro_no,5) ),0) + 1,'000') )");
		builder.append("      FROM                                                     ");
		builder.append("          pro                                                  ");
		builder.append("      WHERE                                                    ");
		builder.append("          substr(pro_no,1,4) = to_char(SYSDATE,'YY')");
		builder.append("          || TRIM(TO_CHAR(?,'00') )                            ");
		builder.append("  ),       ");
		builder.append("        ?,       ");
		builder.append("        ?,       ");
		builder.append("        ?,       ");
		builder.append("        ?,       ");
		builder.append("        ?       ");
		builder.append("    )     ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, Integer.valueOf(vo.getProDep()));
		statement.setObject(2, Integer.valueOf(vo.getProDep()));
		statement.setObject(3, vo.getProNm());
		statement.setObject(4, vo.getProPneNo());
		statement.setObject(5, vo.getProEm());
		statement.setObject(6, vo.getProDep());
		statement.setObject(7, vo.getProBir());

		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();

		return executeUpdate;

	}

	// 교수 수정
	public int updateProfessor(ProfessorVO vo) throws Exception {

		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal",
				"java");
		StringBuilder builder = new StringBuilder();
		builder.append("  UPDATE pro     ");
		builder.append("      SET     ");
		builder.append("          pro_dep = ?,     ");
		builder.append("          pro_nm = ?,     ");
		builder.append("          pro_pne_no = ?,     ");
		builder.append("          pro_em = ?,     ");
		builder.append("          pro_bir = ?     ");
		builder.append("  WHERE     ");
		builder.append("      pro_no = ?     ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, vo.getProDep());
		statement.setObject(2, vo.getProNm());
		statement.setObject(3, vo.getProPneNo());
		statement.setObject(4, vo.getProEm());
		statement.setObject(5, vo.getProBir());
		statement.setObject(6, vo.getProNo());

		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}

	// 교수 제거
	// 관리자가 교수를 삭제
	public int deleteProfessor(ProfessorVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal",
				"java");
		StringBuilder builder = new StringBuilder();
		builder.append("   DELETE FROM pro WHERE  ");
		builder.append("       pro_no = ?  ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, vo.getProNo());
		int executeUpdate = statement.executeUpdate();

		statement.close();
		connection.close();
		return executeUpdate;

	}
}
