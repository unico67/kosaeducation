package day17;

public class ThreadLab1 {

	public static void main(String[] args) throws InterruptedException {
		Thread tA = new A();
		Thread tB = new B();
		Thread tC = new C();
		Thread tD = new D();
		System.out.println("스레드 시작");
		tA.start();
		tB.start();
		tC.start();
		tD.start();
		
		tA.join();
		tB.join();
		tC.join();
		tD.join();
		
		System.out.println("MAIN 수행 종료");
	}
}

class A extends Thread {
	public void run() {
		for(char upper = 'A'; upper <= 'L'; upper++) {
			System.out.println(upper);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class B extends Thread {
	public void run() {
		for(char lower = 'a'; lower <= 'h'; lower++) {
			System.out.println(lower);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class C extends Thread {
	public void run() {
		for(int i = 1; i <= 30; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class D extends Thread {
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println("JAVA");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}