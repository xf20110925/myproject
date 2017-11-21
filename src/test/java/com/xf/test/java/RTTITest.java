package com.xf.test.java;

import org.junit.Test;

/**
 * Created by xuefeng on 2017-10-27.
 */
public class RTTITest {
    @Test
    public void testClass(){
        Class integerClass = Integer.class;
        integerClass = Double.class;
    }
}
