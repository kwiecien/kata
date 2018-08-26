package codewars.validbraces;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BraceChecker {

    private static final List<String> LEFTS = Arrays.asList("(", "[", "{");

    public boolean isValid(String braces) {
        LinkedList<String> lefts = new LinkedList<>();
        for (String brace : braces.split("")) {
            if (LEFTS.contains(brace)) {
                lefts.addLast(brace);
            } else if (!match(lefts.pollLast(), brace)) {
                return false;
            }
        }
        return lefts.isEmpty();
    }

    private boolean match(String left, String right) {
        return determineLeft(right).equals(left);
    }

    private String determineLeft(String right) {
        if (")".equals(right)) {
            return "(";
        } else if ("]".equals(right)) {
            return "[";
        } else if ("}".equals(right)) {
            return "{";
        }
        return "Not matched!";
    }

}
