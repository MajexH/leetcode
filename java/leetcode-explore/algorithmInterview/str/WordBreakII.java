package algorithmInterview.str;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        recursion(res, new ArrayList<>(), 0, s, set);
        return res;
    }

    private void recursion(List<String> res, List<String> tmp, int start, String s, Set<String> set) {
        if (start >= s.length()) {
            res.add(String.join(" ", tmp));
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (set.contains(str)) {
                tmp.add(str);
                recursion(res, tmp, i, s, set);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
