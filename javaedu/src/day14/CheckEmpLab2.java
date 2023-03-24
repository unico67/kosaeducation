package day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

/*
[ JDBC 실습 1 ]

작성 클래스명 : SelectEmpLab

- main() 메서드에 구현할 내용
1. DB 서버로 접속한다.
2. Random 클래스의 객체를 생성하여 true 와 false 랜덤값을 추출한다.

3. true 이면
   emp 테이블에서 모든 직원들의 이름과 월급, 두 개의 컬럼을 추출하여
   다음 형식으로 표준 출력한다.

   XXX 직원의 월급은 x,xxx달러입니다. 
   XXX 직원의 월급은 x,xxx달러입니다.
   XXX 직원의 월급은 xx,xxx달러입니다.
         :
4. false 이면
   emp 테이블에서 모든 직원들의 이름과 입사 날짜를 입사한지 오래된 순으로 추출하여
   다음 형식으로 표준 출력한다.

   XXX 직원은 xxxx년 xx월 xx일에 입사하였습니다. 
   XXX 직원은 xxxx년 xx월 xx일에 입사하였습니다. 
   XXX 직원은 xxxx년 xx월 xx일에 입사하였습니다. 
         :
 */

public class CheckEmpLab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		String query1 = "select ename, format(sal, 0) sal from emp";
		String query2 = "select ename, DATE_FORMAT(hiredate, '%Y년 %m월 %d일') writedate from emp order by writedate";
		
		boolean rand = new Random().nextBoolean();
		try(Connection conn = DriverManager.getConnection(url, user, passwd); 
				Statement stmt = conn.createStatement();){
			ResultSet rs;
			if(rand) {
				rs = stmt.executeQuery(query1);
				while(rs.next()) {
					System.out.printf("%s 직원의 월급은 %s달러입니다.\n", rs.getString("ename"), rs.getString("sal"));
				}
				rs.close();
			} else {
				rs = stmt.executeQuery(query2);
				while(rs.next()) {
					System.out.printf("%s 직원은 %s에 입사하였습니다.\n", rs.getString("ename"), rs.getString("writedate"));
				}
			}
			rs.close();
		}catch(Exception e){
			System.err.println("오류 발생 : " + e);
		}
	}
}
