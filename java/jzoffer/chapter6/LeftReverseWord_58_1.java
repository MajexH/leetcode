package chapter6;

public class LeftReverseWord_58_1 {

    public String reverseLeftWords(String s, int n) {
        if (n == 0) return s;
        n = n % s.length();

        return s.substring(n) + s.substring(0, n);
    }
}
