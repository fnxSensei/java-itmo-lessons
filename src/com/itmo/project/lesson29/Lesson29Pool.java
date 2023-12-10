package com.itmo.project.lesson29;

import java.util.concurrent.*;

public class Lesson29Pool extends ThreadPoolExecutor {
    public Lesson29Pool(int corePoolSize, // изначальный(минимальный) размер пула
                        int maximumPoolSize, //максимальный размер пула
                        long keepAliveTime, //время бездействия потока
                        TimeUnit unit, // ед. измерения keepAliveTime
                        BlockingQueue<Runnable> workQueue) { // очередь для задач
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

}
