package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VisitorList2 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "scott";
			String passwd = "tiger";
			conn = DriverManager.getConnection(jdbcUrl, user, passwd);
			stmt = conn.createStatement();
			String sql = "SELECT id, name, writedate, memo FROM visitor";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.print(rs.getString("id") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getString("writedate") + "\t");
				System.out.println(rs.getString("memo"));
			}
		} catch (Exception e) {
			System.err.println("오류 발생 : " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
