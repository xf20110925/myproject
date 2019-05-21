package com.xf.test.fanpujinke;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xuefeng on 2019/5/21
 */
public class Alg {

    static class Fibonacci {
        //java伪代码实现斐波那契数列输出1000个数值
        public static int[] fibonacci(int n) {
            int[] ans = new int[n];
            ans[0] = 1;
            ans[1] = 2;
            if (n < 2) {
                return ans;
            } else {
                for (int i = 2; i < n; i++) {
                    ans[i] = ans[i - 1] + ans[i - 2];
                }
                return ans;
            }
        }

        public static void main(String[] args) {
            System.out.println(Arrays.toString(fibonacci(1000)));
        }
    }

    class HashMap {
        class Node {
            String k;
            String v;
            Node next;

            public String getKey() {
                return k;
            }

            public void setKey(String k) {
                this.k = k;
            }

            public String getValue() {
                return v;
            }


            public void setValue(String v) {
                this.v = v;
            }
        }

        int initSize = 16;   //初始化数组大小//
        double resize = 0.75;   //每次扩充的阈值
        Node[] array;  //所有节点数组
        int size;   //map数组长度

        public void put(String key, String value) {
            if (array == null) {
                array = new Node[initSize];
            }
            //计算插入位置
            int index = (key.hashCode() % (size - 1));
            //扩容重新排列
            if (size > initSize * resize) {
                resize();
            }
            Node node = array[index];
            if (node == null) {
                //数组下标没有元素,直接放第一位上
                array[index] = node;
                size++;
            } else {
                //key已存在修改值
                if (key == node.getKey()) {
                    node.setValue(value);
                } else {
                    array[index] = node;
                    size++;
                }
            }
        }

        String get(String key) {
            String value = null;
            Node node = array[key.hashCode() % (initSize - 1)];
            while (node != null) {
                if (node.getKey() == key) {
                    value = node.getValue();
                } else {
                    node = node.next;
                }
            }
            return value;
        }

        void resize() {
            Node[] temp = new Node[initSize * 2];
            Node node = null;
            //遍历数组
            for (int i = 0; i < array.length; i++) {
                node = array[i];
                //遍历每个数组下的链表
                while (node != null) {
                    //重新散列
                    int index = node.getKey().hashCode() % (temp.length - 1);
                    //拿到下标位置
                    Node next = node.next;
                    node.next = temp[index];
                    temp[index] = node;
                    node = next;
                }
            }
            array = temp;
            initSize = temp.length;
        }
    }

    class MyQueue {
        //链表容器
        LinkedList<Object> list = new LinkedList<Object>();
        //线程安全的计数器
        AtomicInteger count = new AtomicInteger();
        //final 容器最小容量
        final int minSize = 0;
        //容器最大容量
        final int maxSize;

        public MyQueue(int size) {
            this.maxSize = size;
        }

        //锁
        final Object lock = new Object();

        public void put(Object obj) throws InterruptedException {
            synchronized (lock) {
                while (count.get() == maxSize) {//容器满了 等待别人取 lock.wait(); } }
                    lock.wait();
                }
                list.add(obj);
                //计数器自增
                count.incrementAndGet();
                //唤醒拿的线程
                lock.notify();
            }
        }

        public Object take() throws InterruptedException {
            Object res = null;
            synchronized (lock) {
                while (count.get() == minSize) {
                    //容器空了等别人加元素
                    lock.wait();
                }
                //取第一个元素
                res = list.removeFirst();
                //递减
                count.decrementAndGet();
                //唤醒加的线程
                lock.notify();
            }
            return res;
        }
    }

    class myCopyOnWriteArrayList {
        final ReentrantLock lock = new ReentrantLock();
        Object[] array = new Object[10];

        boolean add(Object e) {
            try {
                lock.lock();
                //加锁
                Object[] tmpArray = array;
                int len = tmpArray.length;
                //复制一份 长度+1
                Object[] newArray = Arrays.copyOf(tmpArray, len + 1);
                //放到最后一位
                newArray[len] = e;
                //替换引用
                array = newArray;
                return true;
            } finally {
                lock.unlock();
            }
        }
    }
}