import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class OddEvenSortAppTest {
    private ArrayOddEven app;

    private void insertRandomData(int maxSize) {
        for (int j = 0; j < maxSize; j++) // fill array with
        { // random numbers
            long n = (long) (java.lang.Math.random() * (maxSize - 1));
            app.insert(n);
        }
    }

    @BeforeEach
    void setupTest() {
        app = new ArrayOddEven(15);   // create the array
    }

    @Test
    void testOddEvenSort() {
        insertRandomData(15);
        long[] randomData = Arrays.copyOf(app.a, app.a.length);

        app.bubbleSort();
        long[] sortedData = Arrays.copyOf(app.a, app.a.length);

        app.a = randomData;
        app.oddEvenSort();
        Assertions.assertArrayEquals(sortedData, app.a, "Sorted arrays should match between bubble and odd-even sort");
    }
}
