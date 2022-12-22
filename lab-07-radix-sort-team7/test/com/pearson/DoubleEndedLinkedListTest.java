package com.pearson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoubleEndedLinkedListTest {
    private DoubleEndedLinkedList<Integer> linkedList;

    @BeforeEach
    void setupTest() {
        linkedList = new DoubleEndedLinkedList<>();   // create the array
    }

    @Test
    void testAsStack() {
        linkedList.insertFirst(10);
        linkedList.insertFirst(11);
        linkedList.insertFirst(12);
        linkedList.insertFirst(13);
        Assertions.assertEquals(13, linkedList.deleteFirst());
        Assertions.assertEquals(12, linkedList.deleteFirst());
        Assertions.assertEquals(11, linkedList.deleteFirst());
        Assertions.assertEquals(10, linkedList.deleteFirst());
    }

    @Test
    void testAsQueue() {
        linkedList.insertLast(10);
        linkedList.insertLast(11);
        linkedList.insertLast(12);
        linkedList.insertLast(13);
        Assertions.assertEquals(10, linkedList.deleteFirst());
        Assertions.assertEquals(11, linkedList.deleteFirst());
        Assertions.assertEquals(12, linkedList.deleteFirst());
        Assertions.assertEquals(13, linkedList.deleteFirst());
    }
}
