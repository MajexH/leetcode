public class FirstUniqChar_50 {

    public char firstUniqChar(String s) {
        int[] memo = new int[255];
        for (char c : s.toCharArray()) {
            memo[c]++;
        }

        for (char c : s.toCharArray()) {
            if (memo[c] == 1) return c;
        }
        return ' ';
    }
}
