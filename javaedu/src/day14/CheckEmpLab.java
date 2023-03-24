package day14;

import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class CheckEmpLab {
	public static void main(String[] args) throws SQLException {
		// 입력 생성
		Scanner sc = new Scanner(System.in);
		String input;
		// 직원 존재 유무에 따라 다른 결과 출력
		// DB Connect
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		String sql;
		Connection conn = DriverManager.getConnection(url, user, passwd);
		while (true) {
			System.out.println("직원의 이름을 입력하세요 >> ");
			sc = new Scanner(System.in);
			input = sc.next();
			sql = "select ename, DATE_FORMAT(hiredate, '%Y년 %m월') hiredate, job from emp where ename = '" + input
					+ "'";

			try (Statement stmt = conn.createStatement(); 
					ResultSet rs = stmt.executeQuery(sql);) {
				if (rs.next()) {
					System.out.println(rs.getString("ename") + "직원은 근무중입니다.");
					System.out.println(
							rs.getString("hiredate") + "에 입사했고 현재 " + rs.getString("job") + "번부서에서 근무하고 있습니다.");
				} else {
					System.out.println(input + "직원은 근무하지 않습니다.");
				}
				System.out.println("계속 검토하시겠습니까? >> (no)");
				// sc = new Scanner(System.in);
				input = sc.next();
				if (Objects.equals(input, "no")) {
					break;
				}
			} catch (Exception e) {
				System.err.println("오류 발생: " + e);
			}
		}
	}
}
