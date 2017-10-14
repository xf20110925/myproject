package com.xf.test.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xuefeng on 2017-10-13.
 */
public class LambdaDemo {

    static class TestRunnable {
        public static void main(String[] args) {
            final ExecutorService pool = Executors.newCachedThreadPool();
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("ok");
                }
            });

            pool.execute(() -> System.out.println("ok"));
        }
    }

    interface Message<I, O> {
        O format(I s);
    }

    static class TestLambda {

      /*  public static void main(String[] args) {
            final Message<String, Integer> m = new Message<String, Integer>() {
                @Override
                public Integer format(String s) {
                    return Integer.valueOf(s);
                }
            };
            final Integer ret = m.format("123");
            System.out.println(ret);
        }*/

        public static void main(String[] args) {
            Message<String, Integer> m = (String s) -> Integer.valueOf(s);
            final Integer ret = m.format("123");
            System.out.println(ret);
        }
    }


    static class TestMehonRef {
        public static void main(String[] args) {
            //static ref
            Message<String, Integer> m = s -> Integer.valueOf(s);//Integer::valueOf;
            System.out.println(m.format("123"));
            //common ref
            String str = "123";
            Message<String, Boolean> m1 = str::startsWith;
            System.out.println(m1.format("1"));
            //construct ref
            Message<Integer, Integer> m2 = Integer::new;
            //特定类型的方法引用
            final Comparator<String> stringComparator = String::compareTo;
            final List<String> list = Arrays.asList("123", "321", "213");
            list.sort(stringComparator);
            System.out.println(list);


        }
    }
}
