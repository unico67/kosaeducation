package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class SelectEmpLab3 {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String passwd = "tiger";
		Connection conn = DriverManager.getConnection(jdbcUrl,user,passwd);
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT ename,sal, to_char(hiredate, 'YYYY'),to_char(hiredate, 'mm'),to_char(hiredate, 'dd') FROM emp ORDER BY hiredate");

		Random ran = new Random();
		boolean type = ran.nextBoolean();
		
		if (type == true) {
			while(rs.next()) {
				System.out.printf("%10s 직원의 월급은 %,8d달러 입니다.\n",rs.getString(1),rs.getInt(2));
			}
		}else {
			while(rs.next()) {
				System.out.printf("%10s 직원은 %s년 %s월 %s일에 입사하였습니다.\n",rs.getString(1),rs.getString(3),rs.getString(4),rs.getString(5));
			}			
		}
	}

}
