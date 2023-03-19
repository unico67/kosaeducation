package day13;

import java.util.ArrayList;
import java.util.List;

public class ThreadEx19 {
	public static void main(String[] args) throws Exception {
		List<Character> buffer = new ArrayList<>();
		Thread t1 = new ShareThread1(buffer);
		Thread t2 = new ShareThread2(buffer);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("버퍼의 크기 : " + buffer.size());
		for (char e : buffer)
			System.out.print(e);
	}
}
