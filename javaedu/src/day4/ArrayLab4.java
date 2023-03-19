package day4;

/*
[ 실습 4 ]
1. ArrayLab4 이라는 클래스를 하나 만든다.
2. 5부터 10사이의 난수를 추출한다.
3. 추출된 난수값을 크기로 갖는 int 타입의 배열을 생성한 후에 이 배열의 
   각각의 원소값으로 1부터 26 사이의 난수를 추출하여 저장한다.
4. 3에서 생성된 int 타입의 배열과 동일한 크기를 갖는 char 타입의 배열을 생성한다.
5. int 타입의 배열에 저장된 각각의 원소값을 이용하여 char 타입의 배열에
    알파벳 소문자를 원소값으로 저장하는데 1이면 'a', 2 이면 'b', ... 26이면 'z'를 저장한다.
6. 두 배열의 원소값을 다음과 같이 출력한다.

    [ 출력형식 ]

    10,1,3,21,6,8,11,26,22,19
    j,a,c,u,f,h,k,z,v,s
 */
public class ArrayLab4 {
	public static void main(String[] args) {
		int arrLength = (int) (Math.random() * 6) + 5;
		int[] arr = new int[arrLength];

		System.out.println("난수의 값 : " + arrLength);
		for (int i = 0; i < arrLength; i++) {
			arr[i] = (int) (Math.random() * 26) + 1;
		}
		char[] cArr = new char[arr.length];
		for (int i = 0; i < arrLength; i++) {
			cArr[i] = (char) (96 + arr[i]);
		}

		for (int i = 0; i < arrLength - 1; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println(arr[arrLength - 1]);
		for (int i = 0; i < arrLength - 1; i++) {
			System.out.print(cArr[i] + ",");
		}
		System.out.println(cArr[arrLength - 1]);
	}
}
