import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DequeTest {
    private Deque deque;

    @BeforeEach
    void setupTest() {
        deque = new Deque(15);   // create the array
    }

    @Test
    void testAsStackLeft() {
        deque.insertLeft(10);
        deque.insertLeft(11);
        deque.insertLeft(12);
        deque.insertLeft(13);
        Assertions.assertEquals(13, deque.removeLeft());
        Assertions.assertEquals(12, deque.removeLeft());
        Assertions.assertEquals(11, deque.removeLeft());
        Assertions.assertEquals(10, deque.removeLeft());
    }

    @Test
    void testAsStackRight() {
        deque.insertRight(10);
        deque.insertRight(11);
        deque.insertRight(12);
        deque.insertRight(13);
        Assertions.assertEquals(13, deque.removeRight());
        Assertions.assertEquals(12, deque.removeRight());
        Assertions.assertEquals(11, deque.removeRight());
        Assertions.assertEquals(10, deque.removeRight());
    }

    @Test
    void testAsQueueLeft() {
        deque.insertLeft(10);
        deque.insertLeft(11);
        deque.insertLeft(12);
        deque.insertLeft(13);
        Assertions.assertEquals(10, deque.removeRight());
        Assertions.assertEquals(11, deque.removeRight());
        Assertions.assertEquals(12, deque.removeRight());
        Assertions.assertEquals(13, deque.removeRight());
    }

    @Test
    void testAsQueueRight() {
        deque.insertRight(10);
        deque.insertRight(11);
        deque.insertRight(12);
        deque.insertRight(13);
        Assertions.assertEquals(10, deque.removeLeft());
        Assertions.assertEquals(11, deque.removeLeft());
        Assertions.assertEquals(12, deque.removeLeft());
        Assertions.assertEquals(13, deque.removeLeft());
    }

    @Test
    void testSize() {
        deque.insertRight(10);
        deque.insertRight(11);
        deque.insertRight(12);
        Assertions.assertEquals(3, deque.size());
    }

    @Test
    void testIsEmpty() {
        Assertions.assertTrue(deque.isEmpty());
        deque.insertRight(10);
        deque.insertRight(11);
        Assertions.assertFalse(deque.isEmpty());
    }

    @Test
    void testIsFull() {
        Assertions.assertFalse(deque.isFull());
        deque.insertRight(1);
        deque.insertRight(2);
        deque.insertRight(3);
        deque.insertRight(4);
        deque.insertRight(5);
        deque.insertRight(6);
        deque.insertRight(7);
        deque.insertRight(8);
        deque.insertRight(9);
        deque.insertRight(10);
        deque.insertRight(11);
        deque.insertRight(12);
        deque.insertRight(13);
        deque.insertRight(14);
        deque.insertRight(15);
        Assertions.assertTrue(deque.isFull());
    }
}
