package jdbcexam;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class ConnectDB {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "scott";
        String passwd = "tiger";
		Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);
		System.out.println(conn.getClass().getName());
		DatabaseMetaData mdata = conn.getMetaData();
		System.out.println(mdata.getClass().getName());
		System.out.println("접속된 DB 서버 : "+
		                        mdata.getDatabaseProductName());
		conn.close();
	}
}
