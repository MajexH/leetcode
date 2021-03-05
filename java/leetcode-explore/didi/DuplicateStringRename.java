package didi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateStringRename {

    private static String[] rename(String[] strs) {
        Map<String, Integer> memo = new HashMap<>();
        String[] res = new String[strs.length];

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (!memo.containsKey(str)) {
                memo.put(str, 0);
                res[i] = str;
                continue;
            }
            res[i] = String.format("%s_%d", str, memo.get(str));
            memo.put(str, memo.get(str) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = (sc.next()).split(",");
        System.out.println(Arrays.toString(rename(strs)));
    }
}
