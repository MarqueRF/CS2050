import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HighArrayTest {
    private HighArray highArray;

    @BeforeEach
    void setupTest() {
        this.highArray = new HighArray(100);
    }

    @Test
    void testInsert() {
        Assertions.assertEquals(0, this.highArray.nElems);
        this.highArray.insert(100);
        Assertions.assertEquals(100, this.highArray.a[0]);
        Assertions.assertEquals(1, this.highArray.nElems);
    }

    @Test
    void testFind() {
        this.highArray.insert(100);
        Assertions.assertEquals(1, this.highArray.find(100));
        Assertions.assertEquals(0, this.highArray.find(101));
    }

    @Test
    void testFindDuplicates() {
        this.highArray.insert(100);
        this.highArray.insert(101);
        this.highArray.insert(102);
        this.highArray.insert(102);
        this.highArray.insert(101);
        this.highArray.insert(102);
        Assertions.assertEquals(1, this.highArray.find(100));
        Assertions.assertEquals(2, this.highArray.find(101));
        Assertions.assertEquals(3, this.highArray.find(102));
    }

    @Test
    void testDelete() {
        this.highArray.insert(100);
        this.highArray.delete(100);
        Assertions.assertEquals(0, this.highArray.a[0]);
        Assertions.assertEquals(0, this.highArray.nElems);
    }
}
