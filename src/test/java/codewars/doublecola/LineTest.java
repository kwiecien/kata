package codewars.doublecola;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LineTest {

    private final String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};

    @Before
    public void setUp() {

    }

    @Test
    public void test1() {
        int n = 1;
        assertEquals("Sheldon", Line.WhoIsNext(names, n));
    }

    @Test
    public void test2() {
        int n = 10000;
        assertEquals("Howard", Line.WhoIsNext(names, n));
    }

}