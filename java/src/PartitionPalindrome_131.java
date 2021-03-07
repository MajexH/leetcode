import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionPalindrome_131 {

    public List<List<String>> partition(String s) {
        Map<Integer, List<List<String>>> memo = new HashMap<>();
        return recursionWithMemo(memo, s, 0);
    }

    public List<List<String>> recursionWithMemo(Map<Integer, List<List<String>>> memo, String s, int start) {
        if (start >= s.length()) {
            return new ArrayList<>();
        }
        if (memo.containsKey(start)) return memo.get(start);
        List<List<String>> res = new ArrayList<>();

        for (int i = start + 1; i <= s.length(); i++) {
            if (check(s, start, i)) {
                String str = s.substring(start, i);
                List<List<String>> children = recursionWithMemo(memo, s, i);
                if (children.size() == 0 && i >= s.length()) {
                    res.add(new ArrayList<>(){{
                        add(str);
                    }});
                } else {
                    for (List<String> child : children) {
                        List<String> tmp = new ArrayList<>(child);
                        tmp.add(0, str);
                        res.add(tmp);
                    }
                }
            }
        }
        memo.put(start, res);
        return res;
    }

    public List<List<String>> partitionWithoutMemo(String s) {
        List<List<String>> res = new ArrayList<>();
        recursion(s, 0, res, new ArrayList<>());
        return res;
    }

    public void recursion(String s, int start, List<List<String>> res, List<String> tmp) {
        if (start == s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            if (check(s, start, i)) {
                tmp.add(s.substring(start, i));
                recursion(s, i, res, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public boolean check(String s, int i, int j) {
        j = j - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionPalindrome_131().partition("aab"));
    }
}
