package day16;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class CreateBookLab1 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		try(Connection conn = DriverManager.getConnection(url, user, passwd);
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate("create table book "
					+ "(id int auto_increment primary key "
					+ ", title varchar(90) "
					+ ", price int "
					+ ", kind char(3) )");
			System.out.println("book 테이블 생성 완료!");						
		} catch (SQLException se1) {
			System.out.println("오류발생");
			se1.printStackTrace();
		}
	}
}
