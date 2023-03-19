package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchEmp {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "scott";
        String passwd = "tiger";
		Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select ename, job, sal, deptno  from emp where ename like '%T%'");
		System.out.printf("%8s%8s%8s%4s\n", "성명", "직무", "급여", "부서");
		System.out.println("  -----------------------------------");
		while (rs.next()) {
				System.out.printf("%10s%12s%8d%4d\n", 
						rs.getString("ename"), rs.getString("job"), 
						rs.getInt("sal"), rs.getInt("deptno"));
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}
