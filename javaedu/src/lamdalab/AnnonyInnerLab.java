package lamdalab;
/*
구현 클래스명 : 제시된 패키지의 소스들을 수정하고 패키지를 압축하여 제출한다.
                   (소스는 3개)

소스를 보고 람다식으로 변경 가능하다고 판단되는 부분은 변경하여 제출한다. 소스 3개 모두~~~
 */
import java.util.ArrayList;
import java.util.Collections;
import day6.Book;
public class AnnonyInnerLab {
	public static void main(String[] args) {
		ArrayList<Book> al = new ArrayList<>();
		al.add(new Book("자바의 정석", "남궁성", 27000));
		al.add(new Book("챗GPT", "반병현", 11700));
		al.add(new Book("스타트 스프링 부트", "남가람", 27000));
		al.add(new Book("Doit! 자바프로그래밍", "박은중", 22500));
		al.add(new Book("이것이 자바다", "신용권,임경균", 36000));

		for (Book el : al) {
			System.out.println(el.getBookInfo());
		}

		Collections.sort(al, (b1, b2)->(b1.getPrice() - b2.getPrice()));
		System.out.println("[소팅 후 ]");
		for (Book el : al) {
			System.out.println(el.getBookInfo());
		}
	}
}
