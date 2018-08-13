package codewars.doublecola;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Line {
    public static String WhoIsNext(String[] names, int n)
    {
        Queue<String> line = new LinkedList<>(Arrays.asList(names));
        int i = 1;
        while (i < n) {
            String person = line.remove();
            line.add(person);
            line.add(person);
            i++;
        }
        return line.remove();
    }
}
