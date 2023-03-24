package day16;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectBookLab1 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		ResultSet rs = null;
		start: try(Connection conn = DriverManager.getConnection(url, user, passwd);
				Statement stmt = conn.createStatement();
				Scanner scan = new Scanner(System.in);) {
				while(true) {
				System.out.print("1. 모두 출력하기\n"
						+ "2. 가격이 높은 순으로 출력하기\n"
						+ "3. 20000 이상의 도서들만 출력하기 \n"
						+ "4. 웹 프로그래밍 도서들만 출력하기\n"
						+ "5. 데이터베이스와 인프라 도서들만 출력하기\n"
						+ "6. 도서명에 '자바'를 포함하는 도서들만 출력하기\n"
						+ "7. 분류별 도서 가격의 평균을 출력하기\n"
						+ "\n"
						+ "\n"
						+ "원하는 메뉴의 번호를 선택 : ");
				int menunum = Integer.parseInt(scan.nextLine());
				String[] arr = {"프로그래밍 언어","웹 프로그래밍","빅데이터","데이터베이스","인프라"};
				switch (menunum) {
				case 1: case 2: 
					String str = "select id, title, concat(format(price,0), '원') ";
					if(menunum==1) {
						rs = stmt.executeQuery(str+"price, kind from book");
					}else{
						rs = stmt.executeQuery(str+"price1, kind from book order by price desc");
					}
					if(rs.next()) {
						System.out.println("id\t\ttitle\t\tprice\t\tkind");
						do {
							System.out.println(rs.getString(1)+"\t\t"+
										rs.getString(2)+"\t\t"+
										rs.getString(3)+"\t\t"+
										arr[rs.getString(4).charAt(2)-'1']);
						} while (rs.next());
					}
					break;
				case 3: case 4: case 5: case 6:
					String str1 = "select title, concat(format(price,0), '원') price from book where ";
					if(menunum==3) {
						rs = stmt.executeQuery(str1+"price>=20000");
					}else if(menunum==4) {
						rs = stmt.executeQuery(str1+"kind = 'b02'");
					}else if(menunum==5) {
						rs = stmt.executeQuery(str1+"kind = 'b04' OR kind = 'b05'");
					}else {
						rs = stmt.executeQuery(str1+"title like '%자바%'");
					}
					if(rs.next()) {
						System.out.println("title\t\tprice");
						do {
							System.out.println(rs.getString(1)+"\t\t"+
										rs.getString(2));
						} while (rs.next());
					}
					break;
				default:
					rs = stmt.executeQuery("select kind, format(avg(price),0) price from book where kind is not null group by kind");
					if(rs.next()) {
						do {
							System.out.printf("%s 도서들의 가격 평균은 %s원입니다.\n", arr[rs.getString(1).charAt(2)-'1'], rs.getString(2));
						} while (rs.next());
					}
				}
				
				//계속할건지
				while(true) {
					System.out.print("\n계속 입력하겠습니까?(y/n) ");
					String aws = scan.nextLine();
					if (aws.equalsIgnoreCase("n")) {
						break start;
					}else if(aws.equalsIgnoreCase("y")) {
						System.out.println();
						break;
					}else {
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
