package imsi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolEx4 {
	public static void main(String[] args) throws Exception {
		ExecutorService singleService = Executors.newSingleThreadExecutor();
		System.out.println(singleService.getClass().getName());
		for (int i = 0; i < 10; i++) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					String threadName = Thread.currentThread().getName();
					System.out.println("작업 스레드 이름: " + threadName + " : " + Thread.currentThread().hashCode());
					System.out.println("처리 종료...");
				}
			};
			singleService.execute(runnable);
			Thread.sleep(1000);
		}
		singleService.shutdown();
	}
}
