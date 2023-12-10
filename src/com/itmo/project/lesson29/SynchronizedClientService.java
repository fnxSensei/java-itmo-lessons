package com.itmo.project.lesson29;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedClientService extends Thread {
    private final List<String> tokens;
    //аналог synchronized
    private ReentrantLock reentrantLock;
    //Разрешение на доступ к ресурсу
    private Semaphore semaphore;


    public SynchronizedClientService(List<String> tokens,
                                     ReentrantLock reentrantLock,
                                     Semaphore semaphore) {

        this.tokens = tokens;
        this.reentrantLock=reentrantLock;
        this.semaphore=semaphore;
    }

    @Override
    public void run() {
        String token;
        try {
            semaphore.acquire(); //запрос разрешения
            reentrantLock.lock();
            token = tokens.removeLast();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }
        String newToken = makeRequest(token);
        synchronized (tokens) {
            tokens.add(newToken);
        }
        semaphore.release();
    }

    private String makeRequest(String token) {
        try {
            System.out.println(Thread.currentThread().getName() +
                    " connected with token " + token);
            Thread.sleep(10_000);
            return UUID.randomUUID().toString();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}