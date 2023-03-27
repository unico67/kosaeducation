package day16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class InsertBookLab1 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		int count = 0;
		start: try(Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement("insert into book(title, price, kind) values (?, ?, ?)");
				Scanner scan = new Scanner(System.in);) {			
			while(true) {
				System.out.print("도서명을 입력하세요 : ");
				String title = scan.nextLine();
				System.out.print("가격을 입력하세요 : ");
				int price = Integer.parseInt(scan.nextLine());
				System.out.print("도서분류에 대한 넘버를 입력하세요.\n"
						+ "1. 프로그래밍 언어\n"
						+ "2. 웹 프로그래밍\n"
						+ "3. 빅데이터\n"
						+ "4. 데이터베이스\n"
						+ "5. 인프라\n"
						+ "선택(1~5) : ");
				int kind = scan.nextInt();
				scan.nextLine();
				if(kind>5||kind<1) {
					System.out.println("잘못된 입력입니다. 도서명부터 다시 입력하세요");
					continue;
				}
				pstmt.setString(1,  title);
				pstmt.setInt(2, price);
				pstmt.setString(3, "b0"+String.valueOf(kind));
				pstmt.executeUpdate();
				System.out.println("\n정보가 입력되었습니다.");
				count++;
				while(true) {
					System.out.print("\n계속 입력하겠습니까?(y/n) ");
					String aws = scan.nextLine();
					if (aws.equalsIgnoreCase("n")) {
						System.out.printf("\n%d개의 데이터 입력 완료!", count);
						break start;
					}else if(aws.equalsIgnoreCase("y")) {
						System.out.println();
						break;
					}else{
						System.out.println("y와 n 둘 중 하나를 눌러주세요");
						System.out.println("(y는 계속하기 n은 그만하기 입니다.)");
					}
				}				
			}					
		} catch (SQLException se1) {
			System.out.println("오류발생");
		}
	}
}
