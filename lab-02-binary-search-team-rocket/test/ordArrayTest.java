import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrdArrayTest {
    private OrdArray ordArray;

    @BeforeEach
    void setupTest() {
        ordArray = new OrdArray(100);   // create the array
    }

    @Test
    void testInsert() {
        ordArray.insert(77, 0);
        ordArray.insert(99, 0);
        ordArray.insert(44, 0);
        ordArray.insert(55, 0);
        ordArray.insert(22, 0);
        ordArray.insert(88, 0);
        ordArray.insert(11, 0);
        ordArray.insert(0, 0);
        ordArray.insert(66, 0);
        ordArray.insert(33, 0);

        Assertions.assertEquals(10, ordArray.nElems);
        Assertions.assertEquals(0, ordArray.a[0]);
        Assertions.assertEquals(11, ordArray.a[1]);
        Assertions.assertEquals(22, ordArray.a[2]);
        Assertions.assertEquals(33, ordArray.a[3]);
        Assertions.assertEquals(44, ordArray.a[4]);
        Assertions.assertEquals(55, ordArray.a[5]);
        Assertions.assertEquals(66, ordArray.a[6]);
        Assertions.assertEquals(77, ordArray.a[7]);
        Assertions.assertEquals(88, ordArray.a[8]);
        Assertions.assertEquals(99, ordArray.a[9]);
    }

    @Test
    void testMerge() {
        long[] array1 = {0, 11, 22, 33, 44, 55, 66, 77, 88, 99};
        long[] array2 = {9, 10, 25, 32, 61, 79, 89, 93};

        long[] merged = ordArray.merge(array1, array2);

        Assertions.assertEquals(18, merged.length);

        Assertions.assertEquals(0, merged[0]);
        Assertions.assertEquals(9, merged[1]);
        Assertions.assertEquals(10, merged[2]);
        Assertions.assertEquals(11, merged[3]);
        Assertions.assertEquals(22, merged[4]);
        Assertions.assertEquals(25, merged[5]);
        Assertions.assertEquals(32, merged[6]);
        Assertions.assertEquals(33, merged[7]);
        Assertions.assertEquals(44, merged[8]);
        Assertions.assertEquals(55, merged[9]);
        Assertions.assertEquals(61, merged[10]);
        Assertions.assertEquals(66, merged[11]);
        Assertions.assertEquals(77, merged[12]);
        Assertions.assertEquals(79, merged[13]);
        Assertions.assertEquals(88, merged[14]);
        Assertions.assertEquals(89, merged[15]);
        Assertions.assertEquals(93, merged[16]);
        Assertions.assertEquals(99, merged[17]);
    }

}
