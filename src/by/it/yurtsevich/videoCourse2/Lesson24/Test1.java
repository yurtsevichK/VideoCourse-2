package by.it.yurtsevich.videoCourse2.Lesson24;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        // Создаем обьект класса каунтдаунлатч, грубый перевод(защелка обратного отсчета)
        // указывается количество итераций,которые мы должны отсчитать назад
        CountDownLatch countDownLatch = new CountDownLatch(3);
        // Создаем три потока
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            // Используя метод сабмит, создадим новый обьект, в качестве аргумента передадим каунтдаунлатч
            executorService.submit(new Processor(countDownLatch));
        }
        // Вызываем метод шатдаун,чтобы прекратить сабмит новых заданий
        executorService.shutdown();
        // Создаем метод эвэйт
        countDownLatch.await();
        System.out.println("Latch has been opened, main thread is proceeding");
    }
}

class Processor implements Runnable {
    private CountDownLatch countDownLatch;

    public Processor(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Отсчитываем назад с помощью метода каунтдаун
        countDownLatch.countDown();
    }
}