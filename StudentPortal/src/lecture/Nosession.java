package lecture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

public class Nosession {
public List<LectureVO> audSelect() throws Exception {
		
		DriverManager.registerDriver(new OracleDriver()); 
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
		Statement statement = connection.createStatement();
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT ");
		builder.append("    a.lec_no, ");
		builder.append("    sub_nm, ");
		builder.append("    dep_nm, ");
		builder.append("    pro_nm, ");
		builder.append("    yr, ");
		builder.append("    sem, ");
		builder.append("    lec_tm, ");
		builder.append("    lec_wk, ");
		builder.append("    rm_nm, ");
		builder.append("    ( ");
		builder.append("        SELECT ");
		builder.append("            COUNT(aud_no) ");
		builder.append("        FROM ");
		builder.append("            aud ");
		builder.append("        WHERE ");
		builder.append("            aud_lec = a.lec_no ");
		builder.append("    )||'/25' aud ");
		builder.append("FROM ");
		builder.append("    lec a, ");
		builder.append("    sub, ");
		builder.append("    dep, ");
		builder.append("    pro, ");
		builder.append("    rm ");
		builder.append("WHERE ");
		builder.append("    lec_sub = sub_no ");
		builder.append("    AND   rm_no = sub_rm ");
		builder.append("    AND   sub_pro = pro_no ");
		builder.append("    AND   dep_no = pro_dep ");
		String sql = builder.toString();
		
		ResultSet resultSet = statement.executeQuery(sql);
		
		ArrayList<LectureVO> list = new ArrayList<>();
		while(resultSet.next()) {
			int lecNo = resultSet.getInt("lec_no");
			String lecSub = resultSet.getString("sub_nm");
			String lecDep = resultSet.getString("dep_nm");
			String proNm = resultSet.getString("pro_nm");
			String yr = resultSet.getString("yr");
			int sem = resultSet.getInt("sem");
			String lecTm = resultSet.getString("lec_tm");
			String lecWk = resultSet.getString("lec_wk");
			String rmNm = resultSet.getString("rm_nm");
			String countAdu = resultSet.getString("aud");
			
			list.add(new LectureVO(lecNo, lecSub, lecDep, proNm, yr, sem, lecTm, lecWk, rmNm, countAdu));
			
		}
		resultSet.close();
		statement.close();
		connection.close();
		
		return list;
	}

}
