package codewars.directionsreduction;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DirReductionTest {
    @Test
    public void testSimpleDirReduc() {
        assertArrayEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
                new String[]{"WEST"},
                DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
        assertArrayEquals("\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"",
                new String[]{},
                DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"}));
    }

    @Test
    public void test2() {
        assertArrayEquals("\"EAST\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\", \"EAST\", \"EAST\", \"SOUTH\", \"NORTH\", \"WEST\"",
                new String[]{"EAST", "NORTH"},
                DirReduction.dirReduc(new String[]{"EAST", "EAST", "WEST", "NORTH", "WEST", "EAST", "EAST", "SOUTH", "NORTH", "WEST"}));
    }

}