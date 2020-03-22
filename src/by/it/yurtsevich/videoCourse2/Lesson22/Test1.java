package by.it.yurtsevich.videoCourse2.Lesson22;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        WaitNotify waitNotify = new WaitNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    waitNotify.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    waitNotify.consume();
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

class WaitNotify {
    public void produce() throws InterruptedException {
        // Обьявляем синхронизованный блок
        synchronized (this) {
            System.out.println("Producer thread started");
            // Метод вейт вызывается только в пределах синхронизованного блока на обьекте определнный в блоке (в данном случае THIS)
            wait(); // 1 - отдаем intrinsic lock, 2 - ждем пока будет вызван нотифай()
            System.out.println("Producer thread resumed");
        }

    }

    public void consume() throws InterruptedException {
        // Ждем 2 секунды,чтобы первым точно вызвался продюс
        Thread.sleep(2000);
        // Создаем сканер, чтобы по нажатию ентера программа продолжилась
        Scanner scanner = new Scanner(System.in);
        // Обьявляем синронайзд блок на обьекте THIS
        synchronized (this){
            System.out.println("Waiting for return key pressed");
            scanner.nextLine();
            // Пробуждаем потом с помощью метода нотифай
            notify();
        }
    }
}