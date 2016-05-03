package com.moss.benchmark;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.moss.model.Person;

public class Benchmark {

    public long size = 0;
    public int time = 0;

    public Benchmark() {
        final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        Runnable task = new Runnable() {

            public void run() {
                time++;
                showTime(time);
                if (time >= 10) {
                    executor.shutdown();
                    System.exit(0);
                }
            }
        };
        executor.scheduleAtFixedRate(task, 1, 1, TimeUnit.SECONDS);

        while (true) {
            Person person = new Person();
            size++;
        }
    }

    public void showTime(int time) {
        System.out.println("Time : " + time + " Objects : " + size);
    }

}
