package by.it.yurtsevich.videoCourse2.Lesson23;

import java.util.LinkedList;
import java.util.Queue;

public class Test1 {

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class ProducerConsumer {
    // Создаем обычную очередь
    private Queue<Integer> queue = new LinkedList();
    // Создаем константу имеющую максимальное количество элементов
    private final int LIMIT = 10;
    // Создаем новый обьект на котором будет происходить синхронизация, обьект должен быть константой
    private final Object lock = new Object();

    public void produce() throws InterruptedException {
        // Создаем переменную которую будем добавлять
        int value = 0;
        // Создаем вечный цикл вайл (тру)
        while (true) {
            // Чтобы не было состояния гонки создаем синронайзд блок на созданном раннее обьекте LOCK
            synchronized (lock) {
                // Создаем условие, что мы не хотим добавлять новый элемент в очередь, если наша очередь полна
                while (queue.size() == LIMIT) {
                    lock.wait();
                }
                // Добавляем в нашу очередь переменную
                queue.offer(value++);
                lock.notify();
            }
        }
    }


    public void consume() throws InterruptedException {
        // Создаем бесконечный цикл вайл(тру)
        while (true) {
            // Создаем синронайзд блок, синронизируемся на раннее созданном обьекте LOCK
            synchronized (lock) {
                // Обрабатываем случай, когда в очереди нет элементов
                while (queue.size() == 0) {
                    lock.wait();
                }
                // Получаем элемент из нашей очереди
                int value = queue.poll();
                System.out.println(value);
                System.out.println("Queue size is: " + queue.size());
                lock.notify();
            }
            Thread.sleep(1000);
        }
    }
}