package day4;
/*
[ 실습 3 ]
1. ArrayLab3 라는 클래스를 하나 만든다.
2. 'J', 'a', 'v', 'a' 라는 element 로 구성되는 char 타입의 배열을 만든다.
3. 각 원소들의 값에서 대문자는 소문자로 소문자는 대문자로 변환하여 저장한다.
4. 배열의 element 들을 다음과 같이 출력한다.
     j
    A
    V
    A
 */


//65 -> 90
//97 -> 122
public class ArrayLab3 {
	public static void main(String[] args) {
		char[] cArr = new char[] {'J', 'a', 'v', 'a'};
		for(int i = 0; i < cArr.length; i++) {
			if(cArr[i] >= 'A' && cArr[i] <= 'Z') {
				cArr[i] += 32;
			}else if(cArr[i] >= 'a' && cArr[i] <= 'z'){
				cArr[i] -= 32;
			}
		}
		for(char c : cArr) {
			System.out.println(c);
		}
	}
}



