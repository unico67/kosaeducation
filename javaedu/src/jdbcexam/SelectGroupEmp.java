package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectGroupEmp {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "scott";
        String passwd = "tiger";
		Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT deptno, concat(count(*),'명') su FROM emp GROUP BY deptno");
		System.out.printf("%8s%12s\n", "부서명", "근무하는 인원");
		System.out.println("  -------------------------------");
		while (rs.next()) {
			System.out.printf("%10s%12s\n", rs.getString("deptno"), rs.getString("su"));
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}
