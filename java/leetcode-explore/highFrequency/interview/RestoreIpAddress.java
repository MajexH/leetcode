package highFrequency.interview;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        recursion(s, 0, 0, res, new ArrayList<>());
        return res;
    }

    public void recursion(String s, int start, int level, List<String> res, List<String> tmp) {
        if (level == 4) {
            if (start == s.length()) {
                res.add(String.join(".", tmp));
            }
            return;
        }

        // 最多三位
        for (int end = start + 1; end <= Math.min(s.length(), start + 3); end++) {
            if (isValid(s, start, end)) {
                tmp.add(s.substring(start, end));
                recursion(s, end, level + 1, res, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public boolean isValid(String s, int i, int j) {
        int len = j - i;
        if (len > 1 && s.charAt(i) == '0') {
            return false;
        }
        int val = Integer.parseInt(s.substring(i, j));
        return val >= 0 && val <= 255;
    }
}
