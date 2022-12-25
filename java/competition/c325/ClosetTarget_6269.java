package c325;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangminjie
 * @since 2022/12/25
 */
public class ClosetTarget_6269 {

    public int closetTarget(String[] words, String target, int startIndex) {

        Map<String, List<Integer>> indexes = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            indexes.computeIfAbsent(words[i], key -> new ArrayList<>()).add(i);
        }

        if (!indexes.containsKey(target)) {
            return -1;
        }

        int res = Integer.MAX_VALUE;

        for (int index : indexes.get(target)) {
            int diff = Math.abs(startIndex - index);
            res = Math.min(res, Math.min(diff, words.length - diff));
        }

        return res;
    }

    public static void main(String[] args) {
        ClosetTarget_6269 solution = new ClosetTarget_6269();
        System.out.println(solution.closetTarget(new String[]{"hello", "i", "am", "leetcode", "hello"}, "hello", 1));
    }
}
