import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SelectSortAppTest {
    private SelectSortApp app;

    @BeforeEach
    void setupTest() {
        app = new SelectSortApp();   // create the array
    }

    @Test
    void testSortLargeRandomArray() {
        Assertions.assertEquals(99999, app.sortLargeRandomArray(), "Sorting large random array should take 99999 swaps");
    }

    @Test
    void testSortLargeInverseArray() {
        Assertions.assertEquals(99999, app.sortLargeInverseArray(), "Sorting large inverse sorted array should take 99999 swaps");
    }

    @Test
    void testSortLargeOrderedArray() {
        Assertions.assertEquals(99999, app.sortLargeOrderedArray(), "Sorting large ordered array should take 99999 swaps");
    }
}
