package day6;

public class Book {
	String title;
	String author;
	int price;

	public Book() {
		this("이것이 자바다", "신용권,임경균", 36000);
	}

	public Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public int getPrice() {
		return price;
	}

	public String getBookInfo() {
		return "제목 : " + title + "\t 저자 : " + author + "\t 가격 : " + price;
	}
}
