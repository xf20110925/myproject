package com.xf.concurrent;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xuefeng on 2017-11-23.
 */
public class MineLockCondition {
    //根据时间控制何时消费，何时生产
    static class RealTimeMark {
        private volatile long lastMillonSec = System.currentTimeMillis();
        private long millonSeconds = 1 * 10000;
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
        private Set<String> pkeys = new HashSet<>();

        public void product() {
            lock.lock();
            try {
                while (System.currentTimeMillis() - lastMillonSec > millonSeconds) {
                    condition.await();
                }
                System.out.println("start poll ...");
                while (System.currentTimeMillis() - lastMillonSec <= millonSeconds) {
                    System.out.println("add-->" + (System.currentTimeMillis() - lastMillonSec));
                    TimeUnit.SECONDS.sleep(1);
                    pkeys.add(LocalDateTime.now().toLocalTime().toString());
                }
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void consume() {
            lock.lock();
            try {
                while (System.currentTimeMillis() - lastMillonSec <= millonSeconds) {
                    condition.await();
                }
                System.out.println(String.format("start consume ... size[%s]", pkeys.size()));
                pkeys.stream().forEach(System.out::println);
                pkeys.clear();
                lastMillonSec = System.currentTimeMillis();
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final RealTimeMark realTimeMark = new RealTimeMark();
        final ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(() -> {
            while (true) realTimeMark.product();
        });
        pool.execute(() -> {
            while (true) realTimeMark.consume();
        });
    }
}
