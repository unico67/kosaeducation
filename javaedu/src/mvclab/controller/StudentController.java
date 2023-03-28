package mvclab.controller;
import mvclab.model.StudentDAO;
import mvclab.model.StudentDTO;

public class StudentController {
	StudentDAO dao = new StudentDAO();	
	StudentDTO dto = new StudentDTO();
	boolean result = false;
	
	public void printAll() {	
		System.out.println(dao.getAllStudent());
	}
	
	public void printScore(String name) {
		dto.setName(name);
		int score = dao.getScore(dto);
		System.out.printf("%s 학생의 점수는 %d 입니다\n",name,score);
	}
	
	public void insert(String name, int score) {
		
		
		dto.setName(name);
		dto.setScore(score);
		result = dao.insertStudent(dto);
		if(result) {
			System.out.println("입력 성공");
		}else {
			System.out.println("입력 실패");
		}
		
	}
	
	public void update(String name, int score) {
		
		dto.setName(name);
		dto.setScore(score);
		result = dao.updateStudent(dto);
		if(result) {
			System.out.println(name + " 학생의 점수를 변경했습니다.");
		}else {
			System.out.println(name + " 학생은 존재하지 않습니다.");
		}
		
	}
	
	public void delete(String name) {
		dto.setName(name);
		result = dao.deleteStudent(dto);
		
		if(result) {
			System.out.println(name + " 학생의 데이터를 삭제했습니다.");
		}else {
			System.out.println(name + " 학생은 존재하지 않습니다.");
		}
		
	}
	
}
