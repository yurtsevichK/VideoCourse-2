package by.it.yurtsevich.videoCourse2.Lesson28;

import java.util.Random;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 1_000_000_000; i++) {
                    // Даем понимание в самом потоке прервали нас или нет
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Thread was interrupted");
                        break;
                    }
                    Math.sin(random.nextDouble());
                }
            }
        });
        System.out.println("Starting thread");

        thread1.start();

         Thread.sleep(1000);
        // Прерываем выполнение потока, интераупт вызывается до JOIN, иначе не дойдем
        thread1.interrupt();

        thread1.join();

        System.out.println("Thread finished");
    }
}
