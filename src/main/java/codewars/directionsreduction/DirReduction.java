package codewars.directionsreduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DirReduction {

    private static final String WEST = "WEST";
    private static final String EAST = "EAST";
    private static final String NORTH = "NORTH";
    private static final String SOUTH = "SOUTH";
    private static int west;
    private static int east;
    private static int north;
    private static int south;
    private static List<String> directions;

    static String[] dirReduc(String[] arr) {
        Arrays.stream(arr).forEach(System.out::println);
        clearDirectionCounters();
        countAllDirections(arr);
        return simplifyDirections();
    }

    private static void clearDirectionCounters() {
        west = 0;
        east = 0;
        north = 0;
        south = 0;
    }

    private static void countAllDirections(String[] arr) {
        Arrays.stream(arr)
                .forEach(DirReduction::countDirection);
    }

    private static void countDirection(String direction) {
        if (NORTH.equals(direction)) {
            north++;
        } else if (SOUTH.equals(direction)) {
            south++;
        } else if (WEST.equals(direction)) {
            west++;
        } else if (EAST.equals(direction)) {
            east++;
        }
    }

    private static String[] simplifyDirections() {
        addDirections();
        return directions.toArray(new String[0]);
    }

    private static void addDirections() {
        directions = new ArrayList<>(countDirections());
        addDirection(NORTH, north, south);
        addDirection(SOUTH, south, north);
        addDirection(WEST, west, east);
        addDirection(EAST, east, west);
    }

    private static int countDirections() {
        return Math.abs(north - south) + Math.abs(west - east);
    }

    private static void addDirection(String directionName, int direction, int oppositeDirection) {
        for (int i = 0; i < Math.max(direction - oppositeDirection, 0); i++) {
            directions.add(directionName);
        }
    }

}
