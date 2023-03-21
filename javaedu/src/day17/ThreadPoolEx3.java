package day17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolEx3 {
	public static void main(String[] args) throws Exception {
		System.out.println("가용 프로세서 개수 : " + Runtime.getRuntime().availableProcessors());
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		for (int i = 0; i < 10; i++) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;

					int poolSize = threadPoolExecutor.getPoolSize();
					String threadName = Thread.currentThread().getName();
					System.out.println("[총 스레드 개수: " + poolSize + "] 작업 스레드 이름: " + threadName + " : "
							+ Thread.currentThread().hashCode());

					System.out.println("처리 종료...");
				}
			};
			executorService.execute(runnable);
			Thread.sleep(1000);
		}
		executorService.shutdown();
	}
}
