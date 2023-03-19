package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectSalEmp {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "scott";
        String passwd = "tiger";
		Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT ename, to_char(sal, '9,999')||'달러' fsal FROM emp ORDER BY sal DESC");
		System.out.printf("%8s%8s\n", "성명", "급여");
		System.out.println("  --------------------------");
		while (rs.next()) {
			System.out.printf("%10s%12s\n", rs.getString("ename"), rs.getString("fsal"));
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}
