package by.it.yurtsevich.videoCourse2.lesson21;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test1 {
    //Создал очередь,которая способна работать с множеством потоков
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        // В этом потоке мы вызываем метод продюс и обрабатываем исключения
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // В этом потоке мы вызываем метод консюм и обрабатываем исключения
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // Запускаю 2 потока
        thread1.start();
        thread2.start();

        // Вызываем метод джоин,чтобы мы в менй дождались пока наши потоки выполнятся
        thread1.join();
        thread2.join();

    }

    // Изображаю деятельность потока( пишущий поток(производитель) )
    private static void produce() throws InterruptedException {
        // Закидываю случайные числа
        Random random = new Random();
        // Создаю бесконечный цикл, пока не остановлю выполнение программы
        while (true) {
            // Помещаю в киью элементы с помощью метода пут, помощью рендома нехтИнт ввожу ограничение числа
            queue.put(random.nextInt(100));
        }
    }

    //Создаю потребителя, который берет элементы из эррэй блокинг ю
    private static void consumer() throws InterruptedException {
        Random random = new Random();
        // Каждый 100 мили секунд берет элемент из нашей кью
        while (true) {
            Thread.sleep(100);
            // Если наше рандомное число от 0 -10 будет равно 5
            if (random.nextInt(10)==5);
            // Метод тейк отличается от полл,тем что ждет наши элементы(поа будут добавлены),если их нету
            System.out.println(queue.take());
            System.out.println("Размер нашей очереди " + queue.size());
        }
    }
}
