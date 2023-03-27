package day16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
(3) 구현 클래스명 : SelectBookLab

- 수행을 시작하면 다음과 같은 메뉴를 출력한다.

	1. 모두 출력하기 -- select * from book;
	2. 가격이 높은 순으로 출력하기 -- select * from book order by price desc;
	3. 20000 이상의 도서들만 출력하기 -- select * from book where price >= 20000;
	4. 웹 프로그래밍 도서들만 출력하기 -- select * from book where kind = 'b02';
	5. 데이터베이스와 인프라 도서들만 출력하기 select * from book where kind = 'b04' or kind = 'b05';
         	6. 도서명에 '자바'를 포함하는 도서들만 출력하기   like %자바%
	7. 분류별 도서 가격의 평균을 출력하기  group by
             

	원하는 메뉴의 번호를 선택 : 

- 반복 처리하게 구현한다.(계속 처리하겠는지 프롬프트하고 계속하겠다고 하면 메뉴 출력부터 반복)
- 가격은 천단위 , 를 추가하고 '원'을 붙여서 출력한다.  concat format
- 1번과 2번은 4개의 컬럼을 모두 출력한다. (모든 행, 모든 열)
- 3번, 4번, 5번, 6번은 도서제목과 가격만 출력한다.
- 7번은 다음과 같은 형식으로 출력한다.

	프로그래밍 언어 도서들의 가격 평균은 x,xxx원입니다.
	웹 프로그래밍 도서들의 가격 평균은 x,xxx원입니다.
	빅데이터 도서들의 가격 평균은 x,xxx원입니다.
	데이터베이스 도서들의 가격 평균은 x,xxx원입니다.
	인프라 도서들의 가격 평균은 x,xxx원입니다.

  도서가 없는 분류의 정보는 제외한다.
 */
enum BookKindInit {
	b01("프로그래밍 언어"), b02("웹 프로그래밍"), b03("빅데이터"), b04("데이터베이스"), b05("인프라");

	private final String kind;

	BookKindInit(String kind) {
		this.kind = kind;
	}

	String returnKind() {
		return kind;
	}
}

public class SelectBookLab5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";

		int selectMenu;
		String ans;
		String[] queryArr = new String[] { "select * from book", "select id, title, price, kind from book",
				"select id, title, price, kind from book order by price desc",
				"select title, price from book where price >= 20000",
				"select id, title, price, kind from book where kind = 'b02'",
				"select title, price from book where kind = 'b04' or kind = 'b05'",
				"select title, price from book where title like '%자바%'",
				"select kind, avg(price) avg_price from book group by kind order by kind;"
		};
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				Statement stmt = conn.createStatement();
				Scanner sc = new Scanner(System.in);) {
			ResultSet rs;
			while (true) {
				System.out.print("원하는 메뉴의 번호를 선택 : ");
				selectMenu = Integer.parseInt(sc.nextLine());
				if (selectMenu > 8 || selectMenu <= 0) {
					System.out.println("번호를 다시 선택해주세요.");
					continue;
				}
				rs = stmt.executeQuery(queryArr[selectMenu]);
				if (selectMenu > 0 && selectMenu <= 2 && rs.next()) {
					do {
						System.out.printf("id: %d  제목: %s  가격: %,d원  분류: %s\n", rs.getInt("id"), rs.getString("title"),
								rs.getInt("price"), rs.getString("kind"));
					} while (rs.next());
				} else if (selectMenu >= 3 && selectMenu <= 6 && rs.next()) {
					do {
						System.out.printf("제목: %s  가격: %,d원\n", rs.getString("title"), rs.getInt("price"));
					} while (rs.next());
				} else if (selectMenu == 7 && rs.next()) {
					do {
						System.out.printf("%s 도서들의 가격 평균은 %,d원입니다.\n",
								BookKindInit.valueOf(rs.getString("kind")).returnKind(), rs.getInt("avg_price"));
					} while (rs.next());
				} else if (!rs.next()) {
					System.out.println("도서의 정보가 없습니다");
				}

				System.out.print("\n계속 조회하겠습니까?(y/n) : ");
				ans = sc.nextLine();
				if (ans.equalsIgnoreCase("y")) {
					continue;
				}
				System.out.println("book 정보 조회 종료");
				break;
			}
			rs.close();

		} catch (SQLException se) {
			System.out.println("오류발생");
			se.printStackTrace();
		} catch (NumberFormatException nfe) {
			System.out.println("숫자가 아닌 다른 키를 입력하였습니다. 다시 실행해주세요");
			nfe.printStackTrace();
		} catch (Exception e) {
			System.out.println("오류발생");
			e.printStackTrace();
		}
	}
}
