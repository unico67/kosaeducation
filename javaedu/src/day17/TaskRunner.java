package day17;

public class TaskRunner implements Runnable {
    private final TaskType taskType;

    public TaskRunner(TaskType taskType) {
        this.taskType = taskType;
    }

    @Override
    public void run() {
        switch (taskType) {
            case UPPER_CASE:
                for (char c = 'A'; c <= 'L'; c++) {
                    System.out.println(c);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case LOWER_CASE:
                for (char c = 'a'; c <= 'h'; c++) {
                    System.out.println(c);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case NUMBER:
                for (int i = 1; i <= 30; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case JAVA:
                for (int i = 0; i < 10; i++) {
                    System.out.println("JAVA");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
}
