package com.pearson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {
    private Queue<Integer> linkedList;

    @BeforeEach
    void setupTest() {
        linkedList = new Queue<>();   // create the array
    }

    @Test
    void testQueue() {
        linkedList.insert(10);
        linkedList.insert(11);
        linkedList.insert(12);
        linkedList.insert(13);
        Assertions.assertEquals(10, linkedList.remove());
        Assertions.assertEquals(11, linkedList.remove());
        Assertions.assertEquals(12, linkedList.remove());
        Assertions.assertEquals(13, linkedList.remove());
    }
}
