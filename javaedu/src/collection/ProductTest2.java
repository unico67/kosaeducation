package collection;

import java.util.Collections;
import java.util.LinkedList;

public class ProductTest2 {

	public static void main(String[] args) {
		LinkedList<Product2> p = new LinkedList<>();
		p.add(new Product2("p100", "TV", "20000"));
		p.add(new Product2("p200", "Computer", "10000"));
		p.add(new Product2("p100", "MP3", "700"));
		p.add(new Product2("p300", "Audio", "1000"));

		Collections.sort(p);
		System.out.println();
		System.out.printf("%-10s%-12s%-10s\n---------------------------------------\n", "제품 ID", "제품명", "가격");
		for (Product2 o : p) {
			System.out.println(o.toString());
		}
	}
}
