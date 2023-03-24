package day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class SelectEmpLab {
	public static void main(String[] args) {
		// DB Connect
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";

		String sql = "select ename, DATE_FORMAT(hiredate, '%Y년 %m월 %d일') hiredate, format(sal, 0) sal from emp";
		boolean rand = new Random().nextBoolean();

		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			if (rs.next()) {
				if (rand) {
					do {
						System.out.print(rs.getString("ename") + "직원의 월급은 ");
						System.out.println(rs.getString("sal") + "달러입니다.");
					} while (rs.next());
				} else {
					do {
						System.out.print(rs.getString("ename") + "직원은 ");
						System.out.println(rs.getString("hiredate") + "에 입사하였습니다.");
					} while (rs.next());
				}
			} else {
				System.out.println("추출된 행이 없숑!!");
			}

		} catch (Exception e) {
			System.err.println("오류 발생: " + e);
		}
	}
}
