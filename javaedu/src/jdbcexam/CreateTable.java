package jdbcexam;

import java.sql.*;
import java.util.Scanner;
public class CreateTable {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "scott";
        String passwd = "tiger";
		Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);
		Statement stmt = conn.createStatement();
		Scanner scan = new Scanner(System.in);
		System.out.print("테이블 생성을 원하면  c 를 삭제하려면 d 를 입력하세요 : ");
		String aws = scan.nextLine();
		
		if (aws.equals("c")) {
			stmt.executeUpdate("CREATE TABLE product "
					+ "(id char(5) primary key, classid char(2), name varchar(50),balance number(5), price number(10,2))");
			System.out.println("테이블이 생성되었습니다.");
		} else {
			stmt.executeUpdate("DROP TABLE product");
			System.out.println("테이블이 삭제되었습니다.");
		}
		scan.close();
		stmt.close();
		conn.close();
	}
}
