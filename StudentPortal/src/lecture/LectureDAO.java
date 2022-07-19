package lecture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.driver.OracleDriver;
import sign.SignVO;

public class LectureDAO {
	//필드
	private static LectureDAO lectureDAO = new LectureDAO();
	
	//생성자
	private LectureDAO() {}
	
	//메소드
	public static LectureDAO getInstance() {
		return lectureDAO;
	}
	public List<LectureVO> selectLecture() throws Exception {
		
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
		Statement statement = connection.createStatement();
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT ");
		builder.append("    lec_no, ");
		builder.append("    yr, ");
		builder.append("    sem, ");
		builder.append("    sub_nm, ");
		builder.append("    lec_sub, ");
		builder.append("    dep_nm, ");
		builder.append("    lec_dep, ");
		builder.append("    lec_tm, ");
		builder.append("    lec_wk ");
		builder.append("FROM ");
		builder.append("    lec, ");
		builder.append("    sub, ");
		builder.append("    dep ");
		builder.append("WHERE ");
		builder.append("    sub_no = lec_sub ");
		builder.append("    AND   lec_dep = dep_no ");
		builder.append(" ORDER BY ");
		builder.append(" 	 lec_no ");
		
		String sql = builder.toString();
		ResultSet resultSet = statement.executeQuery(sql);
		
		List<LectureVO> list = new ArrayList<>();
		
		while(resultSet.next()) {
			String lecNo = resultSet.getString("lec_no");
			String yr = resultSet.getString("yr");
			String sem = resultSet.getString("sem");
			String subNm = resultSet.getString("sub_nm");
			String lecSub = resultSet.getString("lec_sub");
			String depNm = resultSet.getString("dep_nm");
			String lecDep = resultSet.getString("lec_dep");
			String lecTm = resultSet.getString("lec_tm");
			String lecWk = resultSet.getString("lec_wk");
			list.add(new LectureVO(lecNo, yr, sem,subNm, lecSub, depNm, lecDep, lecTm, lecWk));
		}
		resultSet.close();
		statement.close();
		connection.close();
		
		return list;
	}
	public LectureVO selectOneLecture(LectureVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT ");
		builder.append("    lec_no, ");
		builder.append("    yr, ");
		builder.append("    sem, ");
		builder.append("    sub_nm, ");
		builder.append("    lec_sub, ");
		builder.append("    dep_nm, ");
		builder.append("    lec_dep, ");
		builder.append("    lec_tm, ");
		builder.append("    lec_wk ");
		builder.append("FROM ");
		builder.append("    lec, ");
		builder.append("    sub, ");
		builder.append("    dep ");
		builder.append("WHERE ");
		builder.append("    sub_no = lec_sub ");
		builder.append("    AND   lec_dep = dep_no ");
		builder.append("    AND   lec_no = ? ");
		builder.append(" ORDER BY ");
		builder.append(" 	 lec_no ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, vo.getLecNo());
		ResultSet resultSet = statement.executeQuery();
		LectureVO result = null;
		if(resultSet.next()) {
			String lecNo = resultSet.getString("lec_no");
			String yr = resultSet.getString("yr");
			String sem = resultSet.getString("sem");
			String subNm = resultSet.getString("sub_nm");
			String lecSub = resultSet.getString("lec_sub");
			String depNm = resultSet.getString("dep_nm");
			String lecDep = resultSet.getString("lec_dep");
			String lecTm = resultSet.getString("lec_tm");
			String lecWk = resultSet.getString("lec_wk");
			result = new LectureVO(lecNo, yr, sem,subNm,lecSub, depNm, lecDep, lecTm, lecWk);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return result;
	}
	
	public int insertLecture(LectureVO vo) throws Exception {
		
		DriverManager.registerDriver(new OracleDriver()); 
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO lec ( ");
		builder.append("    lec_no, ");
		builder.append("    yr, ");
		builder.append("    sem, ");
		builder.append("    lec_sub, ");
		builder.append("    lec_dep, ");
		builder.append("    lec_tm, ");
		builder.append("    lec_wk ");
		builder.append(") VALUES ( ");
		builder.append("    ?, ");
		builder.append("    ?, ");
		builder.append("    ?, ");
		builder.append("    ?, ");
		builder.append("    ?, ");
		builder.append("    ?, ");
		builder.append("    ? ");
		builder.append(") ");
		
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1,vo.getLecNo());
		statement.setString(2,vo.getYr());
		statement.setString(3,vo.getSem());
		statement.setString(4,vo.getLecSub());
		statement.setString(5,vo.getLecDep());
		statement.setString(6,vo.getLecTm());
		statement.setString(7,vo.getLecWk());
		
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		
		return executeUpdate;
	}
	
	public int updateLecture(LectureVO vo) throws SQLException {

		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal",
				"java");
		StringBuilder builder = new StringBuilder();
		builder.append("  UPDATE lec     ");
		builder.append("      SET     ");
		builder.append("          yr = ?,     ");
		builder.append("          sem = ?,     ");
		builder.append("          lec_sub = ?,     ");
		builder.append("          lec_dep = ?,  ");
		builder.append("          lec_tm = ?,     ");
		builder.append("          lec_wk = ?     ");
		builder.append("  WHERE     ");
		builder.append("      lec_no = ?     ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, vo.getYr());
		statement.setObject(2, vo.getSem());
		statement.setObject(3, vo.getLecSub());
		statement.setObject(4, vo.getLecDep());
		statement.setObject(5, vo.getLecTm());
		statement.setObject(6, vo.getLecWk());
		statement.setObject(7, vo.getLecNo());

		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}
	public List<LectureVO> audSelect() throws Exception {
		
		DriverManager.registerDriver(new OracleDriver()); 
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
		Statement statement = connection.createStatement();
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT ");
		builder.append("    a.lec_no, ");
		builder.append("    sub_nm, ");
		builder.append("    lec_sub, ");
		builder.append("    dep_nm, ");
		builder.append("    lec_dep, ");
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
		builder.append(" ORDER BY ");
		builder.append(" 	 a.lec_no ");
		String sql = builder.toString();
		
		ResultSet resultSet = statement.executeQuery(sql);
		
		ArrayList<LectureVO> list = new ArrayList<>();
		while(resultSet.next()) {
			String lecNo = resultSet.getString("lec_no");
			String subNm = resultSet.getString("sub_nm");
			String lecSub = resultSet.getString("lec_sub");
			String depNm = resultSet.getString("dep_nm");
			String lecDep = resultSet.getString("lec_dep");
			String proNm = resultSet.getString("pro_nm");
			String yr = resultSet.getString("yr");
			String sem = resultSet.getString("sem");
			String lecTm = resultSet.getString("lec_tm");
			String lecWk = resultSet.getString("lec_wk");
			String rmNm = resultSet.getString("rm_nm");
			String countAdu = resultSet.getString("aud");
			
			list.add(new LectureVO(lecNo,subNm, lecSub,depNm, lecDep, proNm, yr, sem, lecTm, lecWk, rmNm, countAdu));
			
		}
		resultSet.close();
		statement.close();
		connection.close();
		
		return list;
	}
	
	public int audInsert(String vo, SignVO session) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
		StringBuilder builder = new StringBuilder();
		builder.append(" INSERT INTO aud ( ");
		builder.append("     aud_lec, ");
		builder.append("     aud_stu, ");
		builder.append("     aud_no ");
		builder.append(" ) VALUES ( ");
		builder.append("     ?, ");
		builder.append("     ?, ");
		builder.append("     aud_seq.nextval ");
		builder.append(" ) ");
		
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, vo);
		statement.setObject(2, session.getId());
		
		int executeQuery = statement.executeUpdate();
		statement.close();
		connection.close();
		
		
		
		return executeQuery;
	}
	
	public List<LectureVO> audSelect(SignVO session) throws Exception {
		  
		  DriverManager.registerDriver(new OracleDriver()); 
		  Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
		  StringBuilder builder = new StringBuilder();
		  builder.append(" SELECT");
		  builder.append("     a.lec_no,");
		  builder.append("     sub_nm,");
		  builder.append("     dep_nm,");
		  builder.append("     pro_nm,");
		  builder.append("     yr,");
		  builder.append("     sem,");
		  builder.append("     lec_tm,");
		  builder.append("     lec_wk,");
		  builder.append("     rm_nm,");
		  builder.append("     (");
		  builder.append("         SELECT");
		  builder.append("             COUNT(aud_no)");
		  builder.append("         FROM");
		  builder.append("             aud");
		  builder.append("         WHERE");
		  builder.append("             aud_lec = a.lec_no");
		  builder.append("     )||'/25' aud");
		  builder.append(" FROM");
		  builder.append("     lec a,");
		  builder.append("     sub,");
		  builder.append("     dep,");
		  builder.append("     pro,");
		  builder.append("     rm,");
		  builder.append("     aud");
		  builder.append(" WHERE");
		  builder.append("     lec_sub = sub_no");
		  builder.append("     AND   rm_no = sub_rm");
		  builder.append("     AND   sub_pro = pro_no");
		  builder.append("     AND   dep_no = pro_dep");
		  builder.append("     AND   aud_lec = lec_no");
		  builder.append("     AND   aud_stu =?");
			builder.append(" ORDER BY ");
			builder.append(" 	 lec_no ");
		
		  String sql = builder.toString();
		  
		  PreparedStatement statement = connection.prepareStatement(sql);
		  statement.setObject(1, session.getId());
		  ResultSet resultSet = statement.executeQuery();
		  ArrayList<LectureVO> list = new ArrayList<>();
		  while(resultSet.next()) {
		     String lecNo = resultSet.getString("lec_no");
			 String subNm = resultSet.getString("sub_nm");
			 String depNm = resultSet.getString("dep_nm");
			 String proNm = resultSet.getString("pro_nm");
			 String yr = resultSet.getString("yr");
			 String sem = resultSet.getString("sem");
			 String lecTm = resultSet.getString("lec_tm");
			 String lecWk = resultSet.getString("lec_wk");
			 String rmNm = resultSet.getString("rm_nm");
			 String countAdu = resultSet.getString("aud");
		         
	         list.add(new LectureVO(lecNo, subNm, depNm, proNm, yr, sem, lecTm, lecWk, rmNm, countAdu));
		         
	      }
	      resultSet.close();
	      statement.close();
	      connection.close();
	      
	      return list;
	   }
	
	

	public String selectOneAud(String lecNo, SignVO session) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT ");
		builder.append("    aud_no ");
		builder.append("FROM ");
		builder.append("    aud ");
		builder.append("WHERE ");
		builder.append("    aud_lec = ? ");
		builder.append("and    aud_stu = ? ");
		builder.append(" ORDER BY ");
		builder.append(" 	 aud_no ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, lecNo);
		statement.setObject(2, session.getId());
		ResultSet resultSet = statement.executeQuery();
		String result = null;
		if(resultSet.next()) {
			result = resultSet.getString("aud_no");
		}
		resultSet.close();
		statement.close();
		connection.close();
		
		return result;
	}
	
public List<LectureVO> beforeAudDelete(SignVO session) throws Exception {
        
        DriverManager.registerDriver(new OracleDriver()); 
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
        StringBuilder builder = new StringBuilder();
        builder.append(" SELECT");
        builder.append("     aud_no,");
        builder.append("     sub_nm,");
        builder.append("     dep_nm,");
        builder.append("     pro_nm,");
        builder.append("     yr,");
        builder.append("     sem,");
        builder.append("     lec_tm,");
        builder.append("     lec_wk,");
        builder.append("     rm_nm,");
        builder.append("     (");
        builder.append("         SELECT");
        builder.append("             COUNT(aud_no)");
        builder.append("         FROM");
        builder.append("             aud");
        builder.append("         WHERE");
        builder.append("             aud_lec = a.lec_no");
        builder.append("     )||'/25' aud");
        builder.append(" FROM");
        builder.append("     lec a,");
        builder.append("     sub,");
        builder.append("     dep,");
        builder.append("     pro,");
        builder.append("     rm,");
        builder.append("     aud");
        builder.append(" WHERE");
        builder.append("     lec_sub = sub_no");
        builder.append("     AND   rm_no = sub_rm");
        builder.append("     AND   sub_pro = pro_no");
        builder.append("     AND   dep_no = pro_dep");
        builder.append("     AND   aud_lec = lec_no");
        builder.append("     AND   aud_stu =?");
		builder.append(" ORDER BY ");
		builder.append(" 	 aud_no ");
      
        String sql = builder.toString();
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, session.getId());
        ResultSet resultSet = statement.executeQuery();
        ArrayList<LectureVO> list = new ArrayList<>();
        while(resultSet.next()) {
          String audNo = resultSet.getString("aud_no");
          String lecSub = resultSet.getString("sub_nm");
          String lecDep = resultSet.getString("dep_nm");
          String proNm = resultSet.getString("pro_nm");
          String yr = resultSet.getString("yr");
          String sem = resultSet.getString("sem");
          String lecTm = resultSet.getString("lec_tm");
          String lecWk = resultSet.getString("lec_wk");
          String rmNm = resultSet.getString("rm_nm");
          String countAdu = resultSet.getString("aud");
                  
          list.add(new LectureVO(audNo, lecSub, lecDep, proNm, yr, sem, lecTm, lecWk, rmNm, countAdu));
               
            }
            resultSet.close();
            statement.close();
            connection.close();
            
            return list;
            }
   
   public LectureVO selectOneAud(LectureVO vo, SignVO session) throws Exception {
      //수강신청 삭제시
      DriverManager.registerDriver(new OracleDriver());
      Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
      StringBuilder builder = new StringBuilder();
      builder.append(" SELECT");
      builder.append("    aud_no,");
      builder.append("    sub_nm,");
      builder.append("    dep_nm,");
      builder.append("    pro_nm,");
      builder.append("    yr,");
      builder.append("    sem,");
      builder.append("    lec_tm,");
      builder.append("    lec_wk,");
      builder.append("    rm_nm,");
      builder.append("    (");
      builder.append("        SELECT");
      builder.append("            COUNT(aud_no)");
      builder.append("        FROM");
      builder.append("            aud");
      builder.append("        WHERE");
      builder.append("            aud_lec = a.lec_no");
      builder.append("    )");
      builder.append("    || '/25' aud");
      builder.append(" FROM");
      builder.append("    lec a,");
      builder.append("    sub,");
      builder.append("    dep,");
      builder.append("    pro,");
      builder.append("    rm,");
      builder.append("    aud");
      builder.append(" WHERE");
      builder.append("    lec_sub = sub_no");
      builder.append("    AND   rm_no = sub_rm");
      builder.append("    AND   sub_pro = pro_no");
      builder.append("    AND   dep_no = pro_dep");
      builder.append("    AND   aud_lec = a.lec_no");
      builder.append("    AND   aud_stu = ?");
      builder.append("    AND   aud_no = ?");
		builder.append(" ORDER BY ");
		builder.append(" 	 aud_no ");
      
      String sql = builder.toString();
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setObject(1, session.getId());
      statement.setObject(2, vo.getLecNo());
      ResultSet resultSet = statement.executeQuery();
      LectureVO result = null;
      if(resultSet.next()) {
         String audNo = resultSet.getString("aud_no");
         String lecSub = resultSet.getString("sub_nm");
         String lecDep = resultSet.getString("dep_nm");
         String proNm = resultSet.getString("pro_nm");
         String yr = resultSet.getString("yr");
         String sem = resultSet.getString("sem");
         String lecTm = resultSet.getString("lec_tm");
         String lecWk = resultSet.getString("lec_wk");
         String rmNm = resultSet.getString("rm_nm");
         String countAdu = resultSet.getString("aud");
         
         result = new LectureVO(audNo, lecSub, lecDep, proNm, yr, sem, lecTm, lecWk, rmNm, countAdu);
      }
      resultSet.close();
      statement.close();
      connection.close();
      
      return result;
   }
   
   public int studentAudDelete(LectureVO vo) throws Exception {
      DriverManager.registerDriver(new OracleDriver());
      Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.15:1521:xe", "StudentPortal", "java");
      StringBuilder builder = new StringBuilder();
      builder.append(" DELETE FROM aud WHERE ");
      builder.append("     aud_no = ? ");
      
      String sql = builder.toString();
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setObject(1,vo.getLecNo());
      
      int executeUpdate = statement.executeUpdate();
      statement.close();
      connection.close();
      return executeUpdate;
   }
	
}