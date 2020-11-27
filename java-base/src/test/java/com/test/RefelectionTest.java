package com.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RefelectionTest {
    @Test
    void test() throws ClassNotFoundException {
        System.out.println(Refelection.class.getName());
        System.out.println(Refelection.class.getSimpleName());
        System.out.println(Refelection.class.getCanonicalName());
        System.out.println(Refelection.class.getPackageName());
        System.out.println(long[].class.getName());
        System.out.println(long[].class.getCanonicalName());


    }

}