package codewars.directionsreduction;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class DirReduction {

    private static final String WEST = "WEST";
    private static final String EAST = "EAST";
    private static final String NORTH = "NORTH";
    private static final String SOUTH = "SOUTH";

    static String[] dirReduc(String[] arr) {
        List<String> directions = new LinkedList<>(Arrays.asList(arr));
        int size = directions.size();
        for (int i = 1; i < size; i++) {
            String previousDirection = directions.get(i - 1);
            String currentDirection = directions.get(i);
            if (previousDirection.equals(opposite(currentDirection))) {
                directions.remove(i - 1);
                directions.remove(i - 1);
                size = directions.size();
                i = Math.max(i - 3, 0);
            }
        }
        return directions.toArray(new String[0]);
    }

    private static String opposite(String direction) {
        if (NORTH.equals(direction)) {
            return SOUTH;
        } else if (SOUTH.equals(direction)) {
            return NORTH;
        } else if (WEST.equals(direction)) {
            return EAST;
        } else if (EAST.equals(direction)) {
            return WEST;
        } else {
            throw new RuntimeException();
        }
    }

}
