package PalindromePartitioning131;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        recursion(s, 0, res, new ArrayList<>());
        return res;
    }

    public void recursion(String str, int index, List<List<String>> res, List<String> temp) {
        if (index == str.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < str.length(); i++) {
            String s = str.substring(index, i + 1);
            if (checkPalindrome(s)) {
                temp.add(s);
                // index表示从哪儿开始选取字符串 因为在现在这个循环里面是 index - i+1 因此 下一个递归里面要用 i+1 作为开始
                recursion(str, i + 1, res, temp);
                // pop
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean checkPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partition("cbbbcc"));
    }
}
