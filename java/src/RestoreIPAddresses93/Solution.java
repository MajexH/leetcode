package RestoreIPAddresses93;

import java.util.*;

public class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        recursion(s, 0, res, new LinkedList<>(), 0);
        return res;
    }

    public void recursion(String str, int index, List<String> res, List<String> temp, int start) {
        if (index == 4) {
            if (start == str.length()) res.add(String.join(".", temp));
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (start + i <= str.length()) {
                final int min = start + i;
                String intercept = str.substring(start, min);
                if (isValid(intercept)) {
                    temp.add(intercept);
                    recursion(str, index + 1, res, temp, min);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public boolean isValid(String str) {
        if (str.length() == 0 || str.length() > 3 || (str.length() > 1 && str.charAt(0) == '0')) return false;
        return Integer.parseInt(str) < 256;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("010010"));
    }
}
