package jdbcexam;

import java.sql.*;
import java.util.Random;

public class SelectTable {
	public static void main(String args[]) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT id, classid, name, balance, price FROM product");
		boolean flag = new Random().nextBoolean();
		if (flag) {
			while (rs.next()) {
				System.out.print(rs.getString(1) + "   ");
				System.out.print(rs.getString(2) + "   ");
				System.out.print(rs.getString(3) + "   ");
				System.out.print(rs.getInt(4) + "   ");
				System.out.println(rs.getFloat(5));				
			}
		} else {
			while (rs.next()) {				
				System.out.print(rs.getString("id") + "   ");
				System.out.print(rs.getString("classid") + "   ");
				System.out.print(rs.getString("name") + "   ");
				System.out.print(rs.getInt("balance") + "   ");
				System.out.println(rs.getFloat("price"));
			}
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}
