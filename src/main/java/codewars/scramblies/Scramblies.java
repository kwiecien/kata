package codewars.scramblies;

public class Scramblies {
    
    public static boolean scramble(String letters, String word) {
        for (String letter : letters.split("")) {
            if (word.contains(letter)) {
                word = word.replaceFirst(letter, "");
            }
        }
        return word.length() == 0;
    }

}