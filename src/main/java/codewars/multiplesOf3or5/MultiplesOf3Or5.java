package codewars.multiplesOf3or5;

import java.util.stream.IntStream;

/**
 * https://www.codewars.com/kata/multiples-of-3-or-5/train/java
 */
public class MultiplesOf3Or5 {
    public int solution(int number) {
        return IntStream.range(3, number)
                .filter(num -> num % 3 == 0 || num % 5 == 0)
                .sum();
    }
}
