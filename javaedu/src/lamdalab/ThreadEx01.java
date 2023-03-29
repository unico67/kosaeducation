package lamdalab;
/*
구현 클래스명 : 제시된 패키지의 소스들을 수정하고 패키지를 압축하여 제출한다.
                   (소스는 3개)

소스를 보고 람다식으로 변경 가능하다고 판단되는 부분은 변경하여 제출한다. 소스 3개 모두~~~
 */
class ThreadEx01 {
	public static void main(String args[]) {
		ThreadEx1_1 t1 = new ThreadEx1_1();

		Thread t2 = new Thread(()->{
			for(int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName());
			}
		}); // 생성자 Thread(Runnable target)

		t1.start();
		t2.start();
	}
}

class ThreadEx1_1 extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(getName()); // 조상인 Thread의 getName()을 호출
		}
	}
}
