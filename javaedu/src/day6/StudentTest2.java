package day6;

public class StudentTest2 {
	public static void main(String[] args) {
		Student2 st1 = new Student2("둘리", 10, "HTML5");
		Student2 st2 = new Student2("또치", 10, "CSS3");
		// Student2 st3 = new Student2();
		System.out.println("st1이 참조하는 객체 정보 : " + st1);
		System.out.println("st2가 참조하는 객체 정보 : " + st2);

		st1.printStudentInfo();
		st1.study();

		st2.printStudentInfo();
		st2.study();

		st2 = st1;
		System.out.println("st1이 참조하는 객체 정보 : " + st1);
		System.out.println("st2가 참조하는 객체 정보 : " + st2);
		st2.printStudentInfo();
		st2.study();
	}
}
