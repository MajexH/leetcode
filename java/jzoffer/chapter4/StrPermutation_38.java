package chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrPermutation_38 {

    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public boolean canSwap(char[] s, int start, int end) {
        for (int i = start; i < end; i++) {
            if (s[i] == s[end]) return false;
        }
        return true;
    }

    public void recursion(List<String> res, char[] s, int index) {
        if (index >= s.length) {
            res.add(new String(s));
            return;
        }
        for (int i = index; i < s.length; i++) {
            if (canSwap(s, index, i)) {
                swap(s, index, i);
                recursion(res, s, index + 1);
                swap(s, index, i);
            }
        }
    }

    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        recursion(res, s.toCharArray(), 0);
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new StrPermutation_38().permutation("aac")));
    }
}
