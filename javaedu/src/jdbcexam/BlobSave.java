package jdbcexam;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class BlobSave {
	public static void main(String args[]) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "scott";
        String passwd = "tiger";
		Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);
		Scanner scan = new Scanner(System.in);
		System.out.print("저장할 이미지 파일명을 입력하세요 : ");
		String fname = scan.nextLine();
		File file = new File("c:/iotest/"+fname);
		InputStream is = new FileInputStream(file);
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO imgtest VALUES (?, ?)");
		pstmt.setString(1, fname);
		pstmt.setBinaryStream(2, is, file.length());
		pstmt.executeUpdate();
		System.out.println("저장 성공!!");
		scan.close();
		pstmt.close();
		conn.close();		
	}
}





