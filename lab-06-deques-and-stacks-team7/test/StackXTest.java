import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackXTest {
    private StackX stackX;

    @BeforeEach
    void setupTest() {
        stackX = new StackX(15);   // create the array
    }

    @Test
    void testStack() {
        stackX.push(10);
        stackX.push(11);
        stackX.push(12);
        stackX.push(13);
        Assertions.assertEquals(13, stackX.pop());
        Assertions.assertEquals(12, stackX.pop());
        Assertions.assertEquals(11, stackX.pop());
        Assertions.assertEquals(10, stackX.pop());
    }

    @Test
    void testIsEmpty() {
        Assertions.assertTrue(stackX.isEmpty());
        stackX.push(10);
        stackX.push(11);
        Assertions.assertFalse(stackX.isEmpty());
    }

    @Test
    void testIsFull() {
        Assertions.assertFalse(stackX.isFull());
        stackX.push(1);
        stackX.push(2);
        stackX.push(3);
        stackX.push(4);
        stackX.push(5);
        stackX.push(6);
        stackX.push(7);
        stackX.push(8);
        stackX.push(9);
        stackX.push(10);
        stackX.push(11);
        stackX.push(12);
        stackX.push(13);
        stackX.push(14);
        stackX.push(15);
        Assertions.assertTrue(stackX.isFull());
    }
}
