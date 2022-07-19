package record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;
import sign.SignVO;

public class RecordDAO {
	private static RecordDAO rcDAO = new RecordDAO();

	private RecordDAO() {
	}

	public static RecordDAO getInstance() {
		return rcDAO;
	}

	public List<RecordVO> selectSub(SignVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal",
				"java");
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT");
		builder.append("     lec_no, ");
		builder.append("     sub_nm, ");
		builder.append("     cre, ");
		builder.append("     pro_nm ");
		builder.append(" FROM");
		builder.append("     lec, ");
		builder.append("     sub, ");
		builder.append("     pro ");
		builder.append(" WHERE ");
		builder.append("     pro_no = sub_pro ");
		builder.append("     AND   sub_no = lec_sub ");
		builder.append("     AND   pro_no = ?");
		builder.append(" ORDER BY ");
		builder.append(" 	 lec_no ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, vo.getId());
		ResultSet resultSet = statement.executeQuery();
		List<RecordVO> list = new ArrayList<>();
		while (resultSet.next()) {
			String lecNo = resultSet.getString("lec_no");
			String subNm = resultSet.getString("sub_nm");
			String cre = resultSet.getString("cre");
			String proNm = resultSet.getString("pro_nm");
			list.add(new RecordVO(lecNo, subNm, cre, proNm));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}

	public List<RecordVO> selectStu(String lecNo, SignVO session) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal",
				"java");
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT");
		builder.append("     stu_nm,");
		builder.append("     a.aud_no,");
		builder.append("     sc,");
		builder.append("     mk,");
		builder.append("     rk");
		builder.append(" FROM");
		builder.append("     stu s,");
		builder.append("     rc r,");
		builder.append("     aud a");
		builder.append(" WHERE");
		builder.append("     r.aud_no = a.aud_no");
		builder.append("     AND   s.stu_no = a.aud_stu");
		builder.append("     AND   aud_lec = (");
		builder.append("         SELECT");
		builder.append("             lec_no");
		builder.append("         FROM");
		builder.append("             lec");
		builder.append("         WHERE");
		builder.append("             lec_sub = (");
		builder.append("                 SELECT");
		builder.append("                     sub_no");
		builder.append("                 FROM");
		builder.append("                     sub");
		builder.append("                 WHERE");
		builder.append("                     sub_pro =?");
		builder.append("                     AND   sub_no =?");
		builder.append("             )");
		builder.append("     )");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, session.getId());
		statement.setObject(2, lecNo);
		ResultSet resultSet = statement.executeQuery();
		List<RecordVO> list = new ArrayList<>();
		while(resultSet.next()) {
			String stuNm = resultSet.getString("stu_nm");
			String audNo = resultSet.getString("aud_no");
			String sc = resultSet.getString("sc");
			String mk = resultSet.getString("mk");
			String rk = resultSet.getString("rk");
			list.add(new RecordVO(stuNm,audNo, sc, mk, rk));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}

	
	public int updateRc(RecordVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal",
				"java");
		StringBuilder builder = new StringBuilder();
		builder.append(" UPDATE rc ");
		builder.append("     SET ");
		builder.append("         sc =?, ");
		builder.append("         mk = ?* 4.5 / 100, ");
		builder.append("         rk = ");
		builder.append("             CASE ");
		builder.append("                 WHEN ? >= 95 THEN 'A+' ");
		builder.append("                 WHEN ? >= 90 THEN 'A' ");
		builder.append("                 WHEN ? >= 85 THEN 'B+' ");
		builder.append("                 WHEN ? >= 80 THEN 'B' ");
		builder.append("                 WHEN ? >= 75 THEN 'C+' ");
		builder.append("                 WHEN ? >= 60 THEN 'C' ");
		builder.append("                 WHEN ? >= 55 THEN 'D+' ");
		builder.append("                 WHEN ? >= 50 THEN 'D' ");
		builder.append("                 ELSE 'f' ");
		builder.append("             END ");
		builder.append(" WHERE ");
		builder.append("     aud_no =? ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, vo.getSc());
		statement.setObject(2, vo.getSc());
		statement.setObject(3, vo.getSc());
		statement.setObject(4, vo.getSc());
		statement.setObject(5, vo.getSc());
		statement.setObject(6, vo.getSc());
		statement.setObject(7, vo.getSc());
		statement.setObject(8, vo.getSc());
		statement.setObject(9, vo.getSc());
		statement.setObject(10, vo.getSc());
		statement.setObject(11, vo.getAudNo());
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}
	
	public List<RecordVO> rcStudentSelect(SignVO session) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT ");
		builder.append("    yr, ");
		builder.append("    sem, ");
		builder.append("    dep_nm, ");
		builder.append("    stu_nm, ");
		builder.append("    sub_nm, ");
		builder.append("    pro_nm, ");
		builder.append("    cre, ");
		builder.append("    com_div, ");
		builder.append("    sc, ");
		builder.append("    mk, ");
		builder.append("    rk ");
		builder.append("FROM ");
		builder.append("    rc r, ");
		builder.append("    aud a, ");
		builder.append("    lec l, ");
		builder.append("    sub s, ");
		builder.append("    pro p, ");
		builder.append("    dep d, ");
		builder.append("    stu s ");
		builder.append("WHERE ");
		builder.append("    r.aud_no = a.aud_no ");
		builder.append("    AND   aud_lec = lec_no ");
		builder.append("    AND   lec_sub = sub_no ");
		builder.append("    AND   sub_pro = pro_no ");
		builder.append("    AND   dep_no = lec_dep ");
		builder.append("    AND   aud_stu = stu_no ");
		builder.append("    AND   stu_no = ? ");
		
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, session.getId());
		
		ResultSet resultSet = statement.executeQuery();
		
		List<RecordVO> list = new ArrayList<>();
		while(resultSet.next()) {
			String yr = resultSet.getString("yr");
			String sem = resultSet.getString("sem");
			String depNm = resultSet.getString("dep_nm");
			String stuNm = resultSet.getString("stu_nm");
			String subNm = resultSet.getString("sub_nm");
			String proNm = resultSet.getString("pro_nm");
			String cre = resultSet.getString("cre");
			String comDiv = resultSet.getString("com_div");
			String sc = resultSet.getString("sc");
			String mk = resultSet.getString("mk");
			String rk = resultSet.getString("rk");
			
			list.add(new RecordVO(yr, sem, depNm, stuNm, subNm, proNm, cre, comDiv, sc, mk, rk));
			
		}
		
		
		statement.close();
		connection.close();
		
		return list;
	}

	public int insertRecord(String audNo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
		StringBuilder builder = new StringBuilder();
		builder.append(" INSERT INTO rc (");
		builder.append("     aud_no");
		builder.append(" ) VALUES (");
		builder.append("     ?");
		builder.append(" )");

		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, audNo);
		
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		
		return executeUpdate;
	}
	
	public int deleteRecord(String audNo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("   DELETE FROM rc WHERE  ");
		builder.append("       aud_no = ?  ");

		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, audNo);
		
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		
		return executeUpdate;
	}
}
