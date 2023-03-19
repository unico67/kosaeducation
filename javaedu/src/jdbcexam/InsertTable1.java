package jdbcexam;

import java.sql.*;

public class InsertTable1 {
	public static void main(String args[]) throws Exception {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
	        String user = "scott";
	        String passwd = "tiger";
			Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO product VALUES" + 
						"('p0001', '10', '자바 프로그래밍',50, 16500)");
			stmt.executeUpdate("INSERT INTO product VALUES" + 
						"('p0002', '10', 'J2EE 구현 패턴',40, 12000)");
			stmt.executeUpdate("INSERT INTO product VALUES"+
						"('p0003', '10', 'JSP 2.0', 60, 18000)");
			System.out.println("데이터들을 추가하였습니다.");
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			//System.out.println("오류 발생 : " + e);
			e.printStackTrace();
		}
	}
}
