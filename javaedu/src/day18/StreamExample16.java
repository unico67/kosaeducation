package day18;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamExample16 {
	public static void main(String[] args) {
		int[] intArray = { 1, 2, 3, 4, 5 };

		IntStream intStream = Arrays.stream(intArray);
		intStream.asDoubleStream().forEach(System.out::println);

		System.out.println();

		intStream = Arrays.stream(intArray);
		intStream.boxed().forEach(System.out::println);
	}
}