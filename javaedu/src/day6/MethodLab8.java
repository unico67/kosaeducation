package day6;

/*
 * [ 실습 3 ]

1. 클래스명 : MethodLab8
2. 정의해야 하는 메서드
   메서드명 : addEven
   매개변수 타입 : int...
   리턴값의 타입 : int
   기능 : 0 개 이상의 int 타입의 데이터들을 전달받아 짝수들의 합만 구하여 리턴한다.  
           아규먼트가 한 개도 전달되지 않으면 -1을 리턴한다.

3. 다음과 같이 addEven() 을 호출하고 리턴 결과를 화면에 출력한다.

   addEven(10, 2, 5, 13, 7)
   addEven(11, 22, 33, 44, 55, 66)
   addEven()
   addEven(100, 101, 103)

    [ 실행 결과 ]

   호출 1 : 12
   호출 2 : 132
   호출 3 : -1
   호출 4 : 100

 */

public class MethodLab8 {

	public static void main(String[] args) {
		int sum1 = addEven(10, 2, 5, 13, 7);
		int sum2 = addEven(11, 22, 33, 44, 55, 66);
		int sum3 = addEven();
		int sum4 = addEven(100, 101, 103);

		System.out.println("호출 1 : " + sum1);
		System.out.println("호출 2 : " + sum2);
		System.out.println("호출 3 : " + sum3);
		System.out.println("호출 4 : " + sum4);
	}

	static int addEven(int... nums) {
		if (nums.length == 0) {
			return -1;
		}
		int sum = 0;
		for (int num : nums) {
			if (num % 2 == 0) {
				sum += num;
			}
		}
		return sum;
	}
}
