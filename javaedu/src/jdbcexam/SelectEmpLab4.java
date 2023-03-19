package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class SelectEmpLab4 {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(
				"select ename, concat(to_char(sal, '9,999'), '달러'), to_char(hiredate,'yyyy\"년 \"mm\"월 \"dd\"일\"') from emp");
		boolean b = new Random().nextBoolean();
		if (b) {
			while (rs.next()) {
				System.out.println(rs.getString("ename") + " 직원의 월급은" + rs.getString(2) + "입니다.");
			}
		} else {
			while (rs.next()) {
				System.out.println(rs.getString(1) + " 직원은 " + rs.getString(3) + "에 입사하였습니다.");
			}
		}		
	}	
}
	
		