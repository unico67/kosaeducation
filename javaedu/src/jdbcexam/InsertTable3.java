package jdbcexam;

import java.sql.*;
import java.util.Scanner;

public class InsertTable3 {
	public static void main(String args[]) throws Exception {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
	        String user = "scott";
	        String passwd = "tiger";
			Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);
			PreparedStatement pstmt = conn.prepareStatement(
					     "INSERT INTO product VALUES(?,?,?,?,?)");
			
			Scanner scan = new Scanner(System.in);
			System.out.print("상품의 아이디를 입력하세요 : ");
			String id = scan.nextLine();
			System.out.print("상품의 카테고리 아이디를 입력하세요 : ");
			String classid = scan.nextLine();
			
			System.out.print("상품명을 입력하세요 : ");
			String name = scan.nextLine();
			
			System.out.print("상품의 보유 수량을 입력하세요 : ");
			int balance = scan.nextInt();
			
			System.out.print("상품 금액을 입력하세요 : ");
			double price = scan.nextDouble();			
			pstmt.setString(1, id);
			pstmt.setString(2, classid);
			pstmt.setString(3, name);
			pstmt.setInt(4, balance);
			pstmt.setDouble(5, price);
			pstmt.executeUpdate();
			System.out.println("데이터들을 추가하였습니다.");
			scan.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("오류 발생 : " + e);
		}
	}
}
