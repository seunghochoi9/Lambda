package com.erichgamma.api.product;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @org.junit.jupiter.api.Test
    void systemOut() {
        Item s = new Item();
        String s3 = s.systemOut();
        System.out.println("-->"+s3);
        String s2 = "Hello";
        Assertions.assertEquals(s.systemOut(), s2);
    }

    @org.junit.jupiter.api.Test
    void add() {
    }
}