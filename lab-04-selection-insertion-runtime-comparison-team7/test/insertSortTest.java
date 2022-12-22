import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InsertSortAppTest {
    private InsertSortApp app;

    @BeforeEach
    void setupTest() {
        app = new InsertSortApp();   // create the array
    }

    @Test
    void testSortLargeRandomArray() {
        Assertions.assertTrue(app.sortLargeRandomArray() > 0, "Sorting large random array should take more than 0 swaps");
    }

    @Test
    void testSortLargeInverseArray() {
        Assertions.assertTrue(app.sortLargeInverseArray() > 0, "Sorting large inverse sorted array should take more than 0 swaps");
    }

    @Test
    void testSortLargeOrderedArray() {
        Assertions.assertTrue(app.sortLargeOrderedArray() == 0, "Sorting large ordered array should take 0 swaps");
    }

    @Test
    void testCompareSortRuntimes() {
        long sortLargeRandomArray = app.sortLargeRandomArray();
        long sortLargeOrderedArray = app.sortLargeOrderedArray();
        long sortLargeInverseArray = app.sortLargeInverseArray();

        Assertions.assertTrue(sortLargeOrderedArray < sortLargeRandomArray &&
                sortLargeRandomArray < sortLargeInverseArray,
                "sorting large inverse array should take more steps than sorting large random array, and " +
                        "sorting large random array should more steps than sorting large ordered array");
    }
}
