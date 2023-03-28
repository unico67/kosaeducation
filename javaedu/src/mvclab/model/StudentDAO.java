package mvclab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import day16.mvc.MySQLConnect;

public class StudentDAO {
	
	int count;
	boolean result = false;

	// 1. 학생 정보 출력
	public List<StudentDTO> getAllStudent() {
		Connection conn = MySQLConnect.connect();
		List<StudentDTO> vlist = null;
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("select name, score from student ");
			vlist = new ArrayList<StudentDTO>();
			while (rs.next()) {
				StudentDTO vo = new StudentDTO();
				vo.setName(rs.getString("name"));
				vo.setScore(rs.getInt("score"));
				vlist.add(vo);
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		MySQLConnect.close(conn);
		return vlist;
	}

	// 2. 학생 정보 입력
	public boolean insertStudent(StudentDTO dto) {
		Connection conn = MySQLConnect.connect();
		try (PreparedStatement pstmt = conn.prepareStatement("insert into student (name, score) values (?, ?)")) {

			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getScore());
			count = pstmt.executeUpdate();
			if (count != 0) {
				result = true;
			} else {
				result = false;
			}

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		MySQLConnect.close(conn);
		return result;
	}
	// 3. 학생 정보 삭제
	public boolean deleteStudent(StudentDTO dto) {
		Connection conn = MySQLConnect.connect();
		try (PreparedStatement pstmt = conn.prepareStatement("delete from student where name = ?")) {

			pstmt.setString(1, dto.getName());
			count = pstmt.executeUpdate();
			if (count != 0) {
				result = true;
			} else {
				result = false;
			}

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		MySQLConnect.close(conn);
		return result;
	}
	// 4. 학생 정보 수정
	public boolean updateStudent(StudentDTO dto) {
		Connection conn = MySQLConnect.connect();
		try (PreparedStatement pstmt = conn.prepareStatement("update student set name = ?,  score = ? where name = ?")) {

			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getScore());
			pstmt.setString(3, dto.getName());
			count = pstmt.executeUpdate();
			
			if (count != 0) {
				result = true;
			} else {
				result = false;
			}

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}

		MySQLConnect.close(conn);
		return result;
	}
	// 5. 학생 점수 확인
	public int getScore(StudentDTO dto) {
		Connection conn = MySQLConnect.connect();
		int score=0;
		try (Statement stmt = conn.createStatement()) {
			
			ResultSet rs = stmt.executeQuery("select score from student where name = '"+dto.getName()+"'");
			
			if(rs.next()) {
				do {
					score = rs.getInt(1);
				}
				while (rs.next());
			}else {
				score = -1;
			}

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		
		MySQLConnect.close(conn);
		return score;
	}

}
