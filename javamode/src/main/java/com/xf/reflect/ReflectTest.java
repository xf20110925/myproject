package com.xf.reflect;

import java.util.Arrays;

/**
 * Created by xuefeng on 2017-11-2.
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException {
        final Class<?> aClass = Class.forName("java.lang.String");
        Arrays.stream(aClass.getMethods()).forEach(System.out::println);
    }
}
