package day11;

import java.util.Date;

public class CreateGenericTest {
	public static void main(String[] args) {
		Value1 o1 = new Value1();
		o1.put("ABC");
		String s1 = o1.get();
		System.out.println(s1);

		Value2 o2 = new Value2();
		o2.put("ABC");
		String s2 = (String) o2.get();
		System.out.println(s2);

		Value2 o3 = new Value2();
		o3.put(new Date());
		Date s3 = (Date) o3.get();
		System.out.println(s3);

		Value3<String> o4 = new Value3<String>();
		o4.put("ABC");
		String s4 = o4.get();
		System.out.println(s4);

		Value3<Date> o5 = new Value3<Date>();
		o5.put(new Date());
		Date s5 = o5.get();
		System.out.println(s5);

		Value3 o6 = new Value3();
	}
}

class Value1 {
	String obj;

	void put(String obj) {
		this.obj = obj;
	}

	String get() {
		return obj;
	}
}

class Value2 {
	Object obj;

	void put(Object obj) {
		this.obj = obj;
	}

	Object get() {
		return obj;
	}
}

class Value3<T> {
	T obj;

	void put(T obj) {
		this.obj = obj;
	}

	T get() {
		return obj;
	}
}
