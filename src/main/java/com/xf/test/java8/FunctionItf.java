package com.xf.test.java8;


import java.util.Arrays;
import java.util.function.*;

/**
 * Created by xuefeng on 2017-10-13.
 */
public class FunctionItf {
    /**
     * 代表了一个接受两个输入参数的操作，并且不返回任何结果
     */
    BiConsumer<String, Integer> biConsumer = (String x, Integer y) -> System.out.println("ok");

    /**
     * 代表了一个接受两个输入参数的方法，并且返回一个结果
     */
    BiFunction<String, Integer, Boolean> biFunction = (String x, Integer y) -> Integer.valueOf(x) > y;

    /**
     * 代表了一个作用于于两个同类型操作符的操作，并且返回了操作符同类型的结果
     */
    BinaryOperator<Integer> binaryOperator = (x, y) -> x + y;

    /**
     * 代表了一个两个参数的boolean值方法
     */
    BiPredicate<String, Integer> biPredicate = (x, y) -> (x + y) instanceof String;

    /**
     * 无参数，返回一个结果。
     */
    Supplier supplier = () -> true;

    /**
     * 代表了接受一个输入参数并且无返回的操作
     */
    Consumer<String> consumer = x -> System.out.println(x);

    /**
     * 接受一个输入参数，返回一个结果。
     */
    Function<Integer, Boolean> function = x -> x > 0;

    /**
     * 接受一个输入参数，返回一个布尔值结果。
     */
    Predicate<Integer> predicate = x -> x > 0;

    public static void main(String[] args) {
        final StringBuilder ret = Arrays.asList("2", "1", "3").stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(ret.toString());
    }

}
