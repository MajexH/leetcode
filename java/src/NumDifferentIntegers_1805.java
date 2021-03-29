import java.util.HashSet;
import java.util.Set;

public class NumDifferentIntegers_1805 {

    public int numDifferentIntegers(String word) {
        int preIndex = -1;
        // 数字可能会太大
        Set<String> set = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) {
                if (preIndex == -1) preIndex = i;
            } else {
                if (preIndex != -1) {
                    set.add(formatNumber(word.substring(preIndex, i)));
                    preIndex = -1;
                }
            }
        }
        if (preIndex != -1) {
            set.add(formatNumber(word.substring(preIndex)));
        }
        return set.size();
    }

    private String formatNumber(String num) {
        int i = 0;
        while (i < num.length()) {
            if (num.charAt(i) != '0') break;
            i++;
        }
        return num.substring(i);
    }

    public static void main(String[] args) {
        System.out.println(new NumDifferentIntegers_1805().numDifferentIntegers("a123bc34d8ef34"));
    }
}
