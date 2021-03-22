import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakIINew_140 {

    public List<String> wordBreakTimeout(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        List<String> res = new ArrayList<>();
        recursion(s, 0, set, res, new ArrayList<>());
        return res;
    }

    private void recursion(String s, int start, Set<String> set, List<String> res, List<String> tmp) {
        if (start > s.length()) return;
        if (start == s.length()) {
            res.add(String.join(" ", tmp));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String str = s.substring(start, end);
            if (set.contains(str)) {
                tmp.add(str);
                recursion(s, end, set, res, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
