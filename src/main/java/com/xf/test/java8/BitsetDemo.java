package com.xf.test.java8;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by xuefeng on 2017-10-11.
 */
public class BitsetDemo {
    public static void main(String[] args) {
        final BitSet bitSet1 = new BitSet();
        for (int i = 0; i < 100; i++) {
            bitSet1.set(String.valueOf(i).hashCode(), true);
        }

        final BitSet bitSet2 = new BitSet();
        for (int i = 100; i < 10000; i++) {
            bitSet2.set(String.valueOf(i).hashCode(), true);
        }
        bitSet1.or(bitSet2);
        System.out.println(bitSet1.size());
        System.out.println(bitSet1.cardinality());
        System.out.println(bitSet1.toString());
        for (int i = 0; i < 1000; i++) {
            final boolean b = bitSet1.get(String.valueOf(i).hashCode());
            System.out.println(b);
        }
    }
}
