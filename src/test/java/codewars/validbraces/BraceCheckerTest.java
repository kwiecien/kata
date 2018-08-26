package codewars.validbraces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BraceCheckerTest {

    private BraceChecker checker = new BraceChecker();

    @Test
    public void testValid1() {
        assertEquals(true, checker.isValid("()"));
    }

    @Test
    public void testValid2() {
        assertEquals(true, checker.isValid("(){}[]"));
    }

    @Test
    public void testValid3() {
        assertEquals(true, checker.isValid("([{}])"));
    }

    @Test
    public void testInvalid1() {
        assertEquals(false, checker.isValid("[(])"));
    }

    @Test
    public void testInvalid2() {
        assertEquals(false, checker.isValid("(}"));
    }

    @Test
    public void testInvalid3() {
        assertEquals(false, checker.isValid("[({})](]"));
    }

    @Test
    public void testInvalid4() {
        assertEquals(false, checker.isValid("(((({{"));
    }

}