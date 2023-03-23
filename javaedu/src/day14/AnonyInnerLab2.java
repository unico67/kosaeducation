package day14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import day6.Book;

public class AnonyInnerLab2 {

	public static void main(String[] args) {

		List<Book> list = new ArrayList<>();

		list.add(new Book("자바의 정석", "남궁성", 27000));
		list.add(new Book("챗GPT", "반병헌", 11700));
		list.add(new Book("스타트 스프링 부트", "남가람", 27000));
		list.add(new Book("Doit! 자바프로그래밍", "박은중", 22500));
		list.add(new Book("이것이 자바다", "신용권,임경균", 36000));

		for (Book bookinfo : list) {
			System.out.println(bookinfo.getBookInfo());
		}
//		Comparator<Book> BookComparator = new Comparator<Book>() {
//
//			@Override
//			public int compare(Book o1, Book o2) {
//
//				return o1.getPrice() - o2.getPrice();
//			}
//		};
//
//		list.sort(BookComparator);

		Collections.sort(list, new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				return o1.getPrice() - o2.getPrice();
			}
		});
		System.out.println("[소팅 후]");
		for (Book bookinfo : list) {
			System.out.println(bookinfo.getBookInfo());
		}
	}
}
