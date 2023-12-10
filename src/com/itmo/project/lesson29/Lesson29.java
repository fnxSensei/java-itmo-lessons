package com.itmo.project.lesson29;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Lesson29 {
    public static void main(String[] args) {
        List<String> tokens = new ArrayList<>(
                Arrays.asList("123", "456", "789"));

        ReentrantLock lock = new ReentrantLock();

        Semaphore semaphore = new Semaphore(tokens.size());


        // токены нужны только для подключения
        // токен можно использовать только один раз
        // использованный токен нужно заменить новым

        new SynchronizedClientService(tokens, lock, semaphore).start();
        new SynchronizedClientService(tokens, lock, semaphore).start();
        new SynchronizedClientService(tokens, lock, semaphore).start();
        new SynchronizedClientService(tokens, lock, semaphore).start();
        new SynchronizedClientService(tokens, lock, semaphore).start();

        ArrayBlockingQueue<String> tokenQueue =
                new ArrayBlockingQueue<>(3, true, Arrays.asList("123", "456", "789"));
        QueueClientService service01 = new QueueClientService(tokenQueue);
//        QueueClientService service02 = new QueueClientService(tokenQueue);
//        QueueClientService service03 = new QueueClientService(tokenQueue);
//        QueueClientService service04 = new QueueClientService(tokenQueue);

        new Thread(service01).start();
        new Thread(service01).start();
        new Thread(service01).start();
        new Thread(service01).start();

        // пулы потоков
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(service01);
        service.execute(service01);
        service.execute(service01);
        service.execute(service01);
        service.shutdown();
        //List<Runnable> runnables = service.shutdownNow();

    }
}