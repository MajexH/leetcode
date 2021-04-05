public class TruncateSentence_1816 {

    public String truncateSentence(String s, int k) {
        s = s.trim();
        StringBuilder builder = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (k == 0) break;
            builder.append(c);
            if (c == ' ') k--;
        }
        return builder.toString().trim();
    }
}
