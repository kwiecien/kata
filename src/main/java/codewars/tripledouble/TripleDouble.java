package codewars.tripledouble;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Write a function
 * TripleDouble(long num1, long num2)
 * which takes in numbers num1 and num2 and returns 1 if there is a straight triple of a number at any place
 * in num1 and also a straight double of the same number in num2.
 * For example:
 * TripleDouble(451999277, 41177722899) == 1 // num1 has straight triple 999s and
 * // num2 has straight double 99s
 * <p>
 * TripleDouble(1222345, 12345) == 0 // num1 has straight triple 2s but num2 has only a single 2
 * TripleDouble(12345, 12345) == 0
 * TripleDouble(666789, 12345667) == 1
 */

class TripleDouble {

    private static final List<String> DOUBLES = Arrays.asList(
            "00", "11", "22", "33", "44", "55", "66", "77", "88", "99");

    private static final List<String> TRIPLES = Arrays.asList(
            "000", "111", "222", "333", "444", "555", "666", "777", "888", "999");

    static int tripleDouble(long num1, long num2) {
        List<Boolean> triples = findMultiples(num1, TRIPLES);
        List<Boolean> doubles = findMultiples(num2, DOUBLES);
        for (int i = 0; i < 10; i++) {
            if (Boolean.TRUE == doubles.get(i) && Boolean.TRUE == triples.get(i)) {
                return 1;
            }
        }
        return 0;
    }

    private static List<Boolean> findMultiples(long num, List<String> multiples) {
        List<Boolean> multiplesFound = initializeListWithFalse(10);
        String number = Long.toString(num);
        for (int i = 0; i < 10; i++) {
            if (number.contains(multiples.get(i))) {
                multiplesFound.set(i, true);
            }
        }
        return multiplesFound;
    }

    private static List<Boolean> initializeListWithFalse(int size) {
        List<Boolean> booleans = Arrays.asList(new Boolean[size]);
        Collections.fill(booleans, Boolean.FALSE);
        return booleans;
    }

}
