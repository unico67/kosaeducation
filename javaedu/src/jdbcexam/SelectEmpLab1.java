package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class SelectEmpLab1 {

	public static void main(String[] args)throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String passwd = "tiger";
		Connection conn = DriverManager.getConnection(jdbcUrl,user,passwd);
		Statement stmt = conn.createStatement();
		Random r = new Random();
		if(r.nextBoolean()) {
			ResultSet rs = stmt.executeQuery("select ename,sal from emp");
			while(rs.next()) {
				System.out.printf("%s직원의 월급은 %,d달러입니다.\n",
						rs.getString("ename"),rs.getInt("sal"));
			}
		}
		else {
			ResultSet rs = stmt.executeQuery("select ename,to_char(hiredate, 'YYYY\"년\" MM\"월\" DD\"일\"') as hd from emp order by hiredate asc");
			while(rs.next()) {
				System.out.printf("%s직원은  %s에 입사하였습니다.\n",
						rs.getString("ename"),rs.getString("hd"));
			}
		}
	}
}
