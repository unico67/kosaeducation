
public class FirstApp {
	/*
	2023년 3월 6일 학습
	자바프로그램을 실행시키면 제일 먼저 호출되는 메서드
	*/
	public static void main(String[] args) {
		System.out.println("안녕? 자바!!");  //마지막의 세미콜론 기호는 생략 불가
		long a = 1;
		for(int i=1; i < 21; i++) {
			a *= i;
			System.out.println(a);
		}
		//pr(new char[] {'a','b'});
		pr('a','b', 'c');
	}
	static void pr(char c0, char... c1) {
		System.out.println(c0);
		System.out.println(c1);
	}
}
