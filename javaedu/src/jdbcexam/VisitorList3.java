package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VisitorList3 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "SELECT id, name, writedate, memo FROM visitor";
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String passwd = "tiger";

		try (Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				System.out.print(rs.getString("id")+"\t");
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getString("writedate")+"\t");
				System.out.println(rs.getString("memo"));
			}
		} catch (Exception e) {
			System.err.println("오류 발생 : " + e);
		}
	}
}
