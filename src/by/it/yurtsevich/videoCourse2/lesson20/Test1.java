package by.it.yurtsevich.videoCourse2.lesson20;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        // pool iz 2 potokov
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Даю 5 заданий
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Work(i));
        }
        // Прекращаем передачу новых заданий
        executorService.shutdown();
        System.out.println("All tasks submitted");

        // Даю время на выполнение
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}

class Work implements Runnable {
    private int id;

    public Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Work" + id + "was completed");
    }
}
