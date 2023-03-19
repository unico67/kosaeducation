package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CheckEmpLab2 {
    public static void main(String[] args) throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");  // 명시적으로 클래스를 로딩한다.
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "scott";
        String passwd = "tiger";
        Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);
        Scanner scan = null;
        while (true) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT ename, to_char(hiredate,'YYYY') year, "
            		+ "to_char(hiredate,'MM') month, deptno  FROM emp "
                    + "WHERE ename = ?");
            scan = new Scanner(System.in);
            System.out.print("검색하고자 하는 직원의 이름을 입력하세요 : ");
            String employeename = scan.nextLine().toUpperCase();
            pstmt.setString(1, employeename);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                do {
                    System.out.printf("%4s 직원은 근무중입니다.\n", rs.getString("ename"));
                    System.out.printf("%4s년 %2s월에 입사했고 %d번 부서에서 근무하고 있습니다.\n",
                            rs.getString("year"), rs.getString("month"),
                            rs.getInt("deptno"));

                } while (rs.next());
            } else {
                System.out.printf("%s 직원은 근무하지 않습니다.\n", employeename);
            }
            System.out.print("\n계속 검색하시겠습니까? (y/n)");
            String response = scan.nextLine();

            if (response.equals("n") || response.equals("N")) {
                System.out.println("검색프로그램을 종료합니다.");                
                rs.close();
                pstmt.close();
                conn.close();
                break;
            }            
        }
        scan.close();
    }
}
