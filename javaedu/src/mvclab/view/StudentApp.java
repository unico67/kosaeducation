package mvclab.view;

import java.util.Scanner;

import mvclab.controller.*;

public class StudentApp {

	public static void main(String[] args) {
		StudentController cont = new StudentController();
		Scanner scan = new Scanner(System.in);
		String name;
		int score;
		loop: while (true) {
			System.out.println("[ 처리하려는 기능을 선택하세요. ]");
			System.out.println("1. 학생 정보 출력 ");
			System.out.println("2. 학생 정보 입력");
			System.out.println("3. 학생 정보 삭제");
			System.out.println("4. 학생 정보 수정");
			System.out.println("5. 학생 점수 확인");
			System.out.println("6. 종료");
			System.out.print("입력 : ");
			String aws = "";
			aws = scan.nextLine();
			switch (aws) {
				case "1":
					cont.printAll();
					break;
				case "2":
					System.out.print("추가 하실 학생 이름을 입력하세요 : ");
					name = scan.nextLine();
					System.out.print("점수를 입력하세요 : ");
					score = Integer.parseInt(scan.nextLine());
					cont.insert(name, score);
					break;
				case "3":
					System.out.print("삭제 하실 학생 이름을 입력하세요 : ");
					name = scan.nextLine();
					cont.delete(name);
					break;
				case "4":
					System.out.print("수정 하실 학생 이름을 입력하세요 : ");
					name = scan.nextLine();
					System.out.print("점수를 입력하세요 : ");
					score = Integer.parseInt(scan.nextLine());
					cont.update(name, score);
					break;
				case "5":
					System.out.print("점수를 확인 하실 학생 이름을 입력하세요 : ");
					name = scan.nextLine();
					cont.printScore(name);
					break;
				case "6":
					break loop;
			}
		}
		scan.close();
	}

}

