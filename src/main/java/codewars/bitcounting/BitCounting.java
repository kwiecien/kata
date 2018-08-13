package codewars.bitcounting;

class BitCounting {

    static int countBits(int n) {
        return Integer.toBinaryString(n)
                .replace("0", "")
                .length();
    }

}
