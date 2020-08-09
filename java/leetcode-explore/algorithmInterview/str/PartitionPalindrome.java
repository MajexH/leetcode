package algorithmInterview.str;

import java.util.ArrayList;
import java.util.List;

public class PartitionPalindrome {

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public void recursion(List<List<String>> res, List<String> temp, int index, String str) {
        if (index == str.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        // 这个是 substring 的 end
        for (int i = index + 1; i <= str.length(); i++) {
            String tempStr = str.substring(index, i);
            if (isPalindrome(tempStr)) {
                temp.add(tempStr);
                recursion(res, temp, i, str);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        recursion(res, new ArrayList<>(), 0, s);
        return res;
    }
}
