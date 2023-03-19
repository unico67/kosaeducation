package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class SelectEmpLab2 {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        Boolean bool = random.nextBoolean();

        Class.forName("oracle.jdbc.OracleDriver");
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "scott";
        String passwd = "tiger";
        Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);
        Statement stmt = conn.createStatement();

        if (bool) {
            ResultSet rs = stmt.executeQuery("select ename, sal from emp");

            while (rs.next()) {
                System.out.printf("%10s 직원의 월급은 %,6d달러입니다.\n",
                        rs.getString("ename"), rs.getInt("sal"));
            }
            rs.close();
        } else {
            ResultSet rs = stmt.executeQuery("SELECT ename, to_char(hiredate,'YYYY')||'년' year, to_char(hiredate,'MM')||'월' month," +
                    " to_char(hiredate,'DD')||'일' date1 from emp order by hiredate");

            while (rs.next()) {
                System.out.printf("%10s 직원은 %6s %4s %4s에 입사하였습니다.\n",
                        rs.getString("ename"), rs.getString("year")
                        , rs.getString("month"), rs.getString("date1"));
            }
            rs.close();

        }

        stmt.close();
        conn.close();
    }
}
