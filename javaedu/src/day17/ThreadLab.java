package day17;

public class ThreadLab {
    public static void main(String[] args) {
        Thread childThread1 = new Thread(new TaskRunner(TaskType.UPPER_CASE));
        Thread childThread2 = new Thread(new TaskRunner(TaskType.LOWER_CASE));
        Thread childThread3 = new Thread(new TaskRunner(TaskType.NUMBER));
        Thread childThread4 = new Thread(new TaskRunner(TaskType.JAVA));

        childThread1.start();
        childThread2.start();
        childThread3.start();
        childThread4.start();

        try {
            childThread1.join();
            childThread2.join();
            childThread3.join();
            childThread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("MAIN 수행 종료");
    }
}

