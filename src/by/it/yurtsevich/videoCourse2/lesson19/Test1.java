package by.it.yurtsevich.videoCourse2.lesson19;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test1 {
    private int counter;

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.main();

    }
}

class Worker {
    Random random = new Random();

    Object lock1 = new Object();
    Object lock2 = new Object();

    private List<Integer> list = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void addToList1() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(random.nextInt(100));
        }
    }

    public void addtoList2() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }

    public void work() {
        for (int i = 0; i < 1000; i++){
            addToList1();
        addtoList2();
    }
    }

    public void main() throws InterruptedException {
        long before = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }

        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        long after = System.currentTimeMillis();

        System.out.println(after - before);
        System.out.println("List1:" + list.size());
        System.out.println("List2:" + list2.size());
    }
}

