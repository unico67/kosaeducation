package jdbcexam;
import java.sql.*; 
public class UpdateTable { 
  public static void main (String args []) throws Exception { 
	if(args.length != 2) {
		System.out.println("프로그램 아규먼트로 상품ID 와 보유량을 입력하세요..");
		return;
	}
	Class.forName("oracle.jdbc.OracleDriver");
	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
    String user = "scott";
    String passwd = "tiger";
	Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);  
    PreparedStatement pstmt = conn.prepareStatement(
         "UPDATE product SET balance = ? WHERE id = ?");            
 
    pstmt.setInt(1, Integer.parseInt(args[1]));
    pstmt.setString(2, args[0]);
    int update_su = pstmt.executeUpdate();
    System.out.println("수정된 레코드 수 : " + update_su); 
    System.out.println("상품번호가 " +args[0] +
    		      "인 상품의 balance 필드를 "+args[1] +"개로 수정하였습니다.");
    pstmt.close();
    conn.close();
  }
}



