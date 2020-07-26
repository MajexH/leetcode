package highFrequency.backTrack;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    private static String[][] map = new String[][]{
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"}
    };

    public void recursion(List<String> res, String digits, int index, List<String> strs) {
        if (index >= digits.length()) {
            res.add(String.join("", strs));
            return;
        }
        for (String temp : map[digits.charAt(index) - '0' - 2]) {
            strs.add(temp);
            recursion(res, digits, index + 1, strs);
            strs.remove(strs.size() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        recursion(res, digits, 0, new ArrayList<>());
        return res;
    }
}
