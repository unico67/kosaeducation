package jdbcexam;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
class BlobRead {
	public static void main(String args[]) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "scott";
        String passwd = "tiger";
		Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);		
		Scanner scan = new Scanner(System.in);
		System.out.print("읽을 이미지 파일명을 입력하세요 : ");
		String fname = scan.nextLine();
		PreparedStatement pstmt = conn.prepareStatement("SELECT imgcontent ic FROM imgtest "
				+ "where name = ?");
		pstmt.setString(1,  fname);
		ResultSet rset = pstmt.executeQuery();
		if (rset.next()) {
			String saveImgFileName = "c:/Temp/"+fname;
			Blob blob = rset.getBlob("ic");
			System.out.println(blob.length()+"바이트 크기");
			InputStream is = blob.getBinaryStream();
			FileOutputStream fo = new FileOutputStream(saveImgFileName);
			int c = 0;
			while ((c = is.read()) != -1)
				fo.write(c);
			if (fo != null) fo.close();
			if (is != null) is.close();
			Runtime.getRuntime().exec
			("C:/Program Files/Google/Chrome/Application"
					+ "/chrome.exe "+saveImgFileName);
		} else {
			System.out.println("추출된 데이터가 없습니다!!");
		}
		scan.close();
		rset.close();
		pstmt.close();
		conn.close();
	}
}
