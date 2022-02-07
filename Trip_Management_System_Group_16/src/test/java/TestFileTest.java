import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;

class TestFileTest {

    @Test
    void correctSum()
    {
        TestFile test = new TestFile();
        int a =5;
        int b= 98;
        int actual = test.add(a,b);
        int expected = 103;
        Assertions.assertEquals(expected,actual,"Test Passed");
    }

    @Test
    void incorrectSum()
    {
        TestFile test = new TestFile();
        int a =5;
        int b= 98;
        int actual = test.add(a,b);
        int expected = 10000;
        Assertions.assertNotEquals(expected,actual,"Test Passed");
    }
}