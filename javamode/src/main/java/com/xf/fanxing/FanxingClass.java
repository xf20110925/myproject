package com.xf.fanxing;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.stream.IntStream;

/**
 * 泛型类
 * Created by xuefeng on 2017-11-7.
 */
public class FanxingClass {
    interface Generator<T> {
        T next();
    }

    static class Fibonacci implements Generator<Integer> {
        private Integer num = 1;

        @Override
        public Integer next() {
            return fib(num++);
        }

        private int fib(int n) {
            if (n <= 2) {
                return 1;
            }
            return fib(n - 1) + fib(n - 2);
        }

        public static void main(String[] args) {
            final Fibonacci fibonacci = new Fibonacci();
            IntStream.range(1, 10).forEach(i -> System.out.println(fibonacci.next()));
        }
    }

    /**
     * 通过继承的方式实现<Fibonacci>适配器
     */
    static class IteratorFibonacci extends Fibonacci implements Iterable<Integer> {
        int count;

        public IteratorFibonacci(int count) {
            this.count = count;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                @Override
                public boolean hasNext() {
                    return count > 0;
                }

                @Override
                public Integer next() {
                    count--;
                    return IteratorFibonacci.this.next();
                }
            };
        }

        public static void main(String[] args) {
            final IteratorFibonacci fibonacciIt = new IteratorFibonacci(10);
            for (final Integer i : fibonacciIt) {
                System.out.println(i);
            }
        }
    }

    /**
     * 使用组合代替继承的方式适配,生成<Fibonacci>适配器
     */
    static class CombineIteratorFibonacci implements Iterable<Integer> {
        int count;
        private Fibonacci fibonacci = new Fibonacci();

        public CombineIteratorFibonacci(int count) {
            this.count = count;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                @Override
                public boolean hasNext() {
                    return count > 0;
                }

                @Override
                public Integer next() {
                    count--;
                    return fibonacci.next();
                }
            };
        }

        public static void main(String[] args) {
            final CombineIteratorFibonacci combineIteratorFibonacci = new CombineIteratorFibonacci(20);
            for (final Integer integer : combineIteratorFibonacci) {
                System.out.println(integer);
            }
        }
    }

}
