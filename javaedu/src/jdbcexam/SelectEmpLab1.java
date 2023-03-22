package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class SelectEmpLab1 {

	public static void main(String[] args)throws Exception {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		Connection conn = DriverManager.getConnection(url,user,passwd);
		Statement stmt = conn.createStatement();
		ResultSet rs;
		Random r = new Random();
		if(r.nextBoolean()) {
			rs = stmt.executeQuery("select ename, FORMAT(sal, 0) fsal from emp");
			while (rs.next()) {
				System.out.printf("%s 직원의 월금은 %s달러입니다.\n",
				rs.getString("ename"),  rs.getString("fsal"));
			}
		}
		else {
			rs = stmt.executeQuery("SELECT ename, DATE_FORMAT(hiredate, '%Y년 %m월 %d일') hday from emp order by hiredate asc");
			while (rs.next()) {
				System.out.printf("%s 직원은 %s에 입사하였습니다.\n",
				rs.getString("ename"), rs.getString("hday"));
			}
		}
		rs.close();
		stmt.close();
		conn.close();

	}
}
