package day18;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class StreamExample4 {
	public static int sum;

	public static void main(String[] args) {
		IntStream stream = IntStream.rangeClosed(1, 10);
		stream.forEach(a -> sum += a);
		System.out.println("총합: " + sum);
		System.out.println("---------------------------------");
		stream = IntStream.rangeClosed(1, 10);
		stream.forEach(System.out::println);
		System.out.println("---------------------------------");
		stream = IntStream.range(1, 10);
		stream.forEach(System.out::println);
		System.out.println("---------------------------------");
		stream = IntStream.of(10, 20, 30, 40, 50);
		stream.forEach(System.out::println);
		System.out.println("---------------------------------");
		DoubleStream stream2 = DoubleStream.of(3, 4, 3.4, 10.0, 5.2);
		stream2.forEach(System.out::println);
		
	}
}