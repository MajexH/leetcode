import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {

    public void recursion(List<List<String>> res, List<String> temp, int start, String s) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String tempStr = s.substring(start, i);
            if (checkPalindrome(tempStr)) {
                temp.add(tempStr);
                recursion(res, temp, i, s);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean checkPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        recursion(res, new ArrayList<>(), 0, s);
        return res;
    }
}
