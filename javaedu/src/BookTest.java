import java.util.ArrayList;
import java.util.Collections; 
import java.util.Comparator;

import day6.Book;
public class BookTest {

	public static void main(String[] args) {
		Book[] books = new Book[5];

		books[0] = new Book("자바의 정석", "남궁성", 27000);
		books[1] = new Book("챗GPT", "반병현", 11700);
		books[2] = new Book("스타트 스프링 부트", "남가람", 27000);
		books[3] = new Book("Doit! 자바프로그래밍", "박은중", 22500);
		books[4] = new Book();
		
		ArrayList<Book> list = new ArrayList<>();
		
		for (Book obj : books) {
			list.add(obj);
		}		

		for (Book obj : list) {
			System.out.println(obj.getBookInfo());
		}
		
		Collections.sort(list, new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				if(o1.getPrice() < o2.getPrice())
					return -1;
				else if (o1.getPrice() < o2.getPrice())
					return 1;
				else 
					return 0;
			}			
		});
		System.out.println("[소팅 후 ]");
		for (Book obj : list) {
			System.out.println(obj.getBookInfo());
		}
	}
}
