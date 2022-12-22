package edu.msudenver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

class RadixSortTest {
    private RadixSort radixSort;

    @BeforeEach
    void setupTest() {
        radixSort = new RadixSort();   // create the array
    }

    @Test
    void testSort() {
        int[] intArray = new int[100];

        Random random = new Random();
        for(int i = 0; i < 100; i++) {
            intArray[i] = random.nextInt(Integer.MAX_VALUE);
        }

        radixSort.sort(intArray);

        int prev = -1;
        for(int i = 0; i < 100; i++) {
            Assertions.assertTrue(prev <= intArray[i], prev + " should be less than or equal to position "
                    + i + " of sorted array, " + intArray[i]);
            prev = intArray[i];
        }
    }

    @Test
    void testGetNumDigits() {
        Assertions.assertEquals(1, radixSort.getNumDigits(1), "1 should contain 1 digit");
        Assertions.assertEquals(2, radixSort.getNumDigits(10), "10 should contain 2 digits");
        Assertions.assertEquals(3, radixSort.getNumDigits(100), "100 should contain 3 digits");
        Assertions.assertEquals(4, radixSort.getNumDigits(1000), "1000 should contain 4 digits");
    }

    @Test
    void testMaxNumDigits() {
        int[] testArray = {1, 10, 100, 1000};

        Assertions.assertEquals(4, radixSort.getMaxNumDigits(testArray), "array should have 4 digits max");
    }

    @Test
    void testGetSpecificDigit() {
        int test = 123456;
        Assertions.assertEquals(6, radixSort.getSpecificDigit(test, 0), "position 0 of 123456 should be 6");
        Assertions.assertEquals(5, radixSort.getSpecificDigit(test, 1), "position 1 of 123456 should be 5");
        Assertions.assertEquals(4, radixSort.getSpecificDigit(test, 2), "position 2 of 123456 should be 4");
        Assertions.assertEquals(3, radixSort.getSpecificDigit(test, 3), "position 3 of 123456 should be 3");
        Assertions.assertEquals(2, radixSort.getSpecificDigit(test, 4), "position 4 of 123456 should be 2");
        Assertions.assertEquals(1, radixSort.getSpecificDigit(test, 5), "position 5 of 123456 should be 1");
        Assertions.assertEquals(0, radixSort.getSpecificDigit(test, 6), "position 6 of 123456 (out of bounds) should be 0");
    }
}
