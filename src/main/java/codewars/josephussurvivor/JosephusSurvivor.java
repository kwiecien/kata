package codewars.josephussurvivor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class JosephusSurvivor {

    private static int counter;
    private static int killed;
    private static List<Boolean> people;

    static int josephusSurvivor(final int n, final int k) {
        setUpData(n);
        while (true) {
            for (int i = 1; i < people.size(); i++) {
                Boolean alive = people.get(i);
                if (alive.equals(Boolean.TRUE)) {
                    counter++;
                    if (counter == k) {
                        counter = 0;
                        killPerson(i);
                        if (killed == n) {
                            return i;
                        }
                    }
                }
            }
        }
    }

    private static void setUpData(int n) {
        counter = 0;
        killed = 0;
        people = createTrueArray(n + 1);
    }

    private static List<Boolean> createTrueArray(int size) {
        List<Boolean> people = new ArrayList<>(Arrays.asList(new Boolean[size]));
        Collections.fill(people, Boolean.TRUE);
        return people;
    }

    private static void killPerson(int i) {
        killed++;
        people.set(i, Boolean.FALSE);
    }

}
