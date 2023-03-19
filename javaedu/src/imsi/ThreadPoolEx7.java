package imsi;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolEx7 {
	public static void main(String[] args) {
		ExecutorService singleService = Executors.newSingleThreadExecutor();
		CompletableFuture<Integer> future = new CompletableFuture<>();

		Callable<Integer> task = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for (int i = 1; i <= 10; i++) {
					sum += i;
					try {
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName() + " -계산중");
					} catch (Exception e) {
					}
				}
				future.completeAsync(() -> 100);
				return null;
			}
		};
		singleService.submit(task);
		System.out.println("[스레드에게 일을 시킴]");
		try {
			int sum = future.get();
			System.out.println("[처리 결과] " + sum);
			System.out.println("[작업 처리 정상 종료]");
		} catch (Exception e) {
			System.out.println("[실행 예외 발생함] " + e.getMessage());
		}
		singleService.shutdown();
	}
}
