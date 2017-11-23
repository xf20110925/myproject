package com.xf.concurrent;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xuefeng on 2017-11-23.
 */
public class LockCondition {
    static class Business {
        private boolean bool = true;
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public /*synchronized*/ void main(int loop) throws InterruptedException {
            lock.lock();
            try {
                while (bool) {
                    System.out.println("main挂起");
                    condition.await();//this.wait();
                }
                for (int i = 0; i < loop; i++) {
                    System.out.println("main thread seq of " + i + ", loop of " + loop);
                }
                bool = true;
                condition.signal();//this.notify();
            } finally {
                lock.unlock();
            }
        }

        public /*synchronized*/ void sub(int loop) throws InterruptedException {
            lock.lock();
            try {
                while (!bool) {
                    System.out.println("sub挂起");
                    condition.await();//this.wait();
                }
                for (int i = 0; i < loop; i++) {
                    System.out.println("sub thread seq of " + i + ", loop of " + loop);
                }
                bool = false;
                condition.signal();//this.notify();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final Business business = new Business();
        final ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(() -> {
            try {
                while (true)
                    business.main(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.execute(() -> {
            try {
                while (true)
                    business.sub(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}
