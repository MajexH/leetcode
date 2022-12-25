package c325;

/**
 * @author zhangminjie
 * @since 2022/12/25
 */
public class TakeCharacters_6270 {

    private int res = 0;

    public int takeCharacters(String s, int k) {

        // 校验 a b c 字符时候有 k 个
        int[] counters = new int[3];
        for (char c : s.toCharArray()) {
            counters[c - 'a']++;
        }

        for (int counter : counters) {
            if (counter < k) {
                return -1;
            }
        }

//        this.res = Integer.MAX_VALUE;
//        this.recursion(new int[3], k, 0, s, 0, s.length() - 1, new HashSet<>());
//
//        return this.res;
        int res = Integer.MAX_VALUE;
        // 没得必要去拿数据得 其实只需要知道最短的前后加起来满足 isValid 的数据即可
        // 那也就是反过来 从中间开始 直到最短的左右加起来等于 isValid 即可
        // 任意选择中间一个位置开始的 counter > k 的char 开始减去
        // 滑动窗口数据即可
        int[] up = new int[]{counters[0] - k, counters[1] - k, counters[2] - k};
        int[] remainingCounters = new int[3];
        for (int i = 0, j = 0; j < s.length(); j++) {
            remainingCounters[s.charAt(j) - 'a']++;
            // 如果 remainingCounters 比 up 大 那么说明剩下的没有 k 个了 就需要移动左边界
            // 要移动左边的边界
            while (remainingCounters[s.charAt(j) - 'a'] > up[s.charAt(j) - 'a']) {
                remainingCounters[s.charAt(i) - 'a']--;
                i++;
            }
            res = Math.min(res, s.length() - (j - i + 1));
        }
        return res;
    }

    private void recursion(int[] counters, int k, int minutes, String s, int start, int end) {

        if (this.isValid(counters, k)) {
            this.res = Math.min(this.res, minutes);
            return;
        }

        // 不能满足条件了
        if (start > end) {
            return;
        }

        // 从 start 取
        counters[s.charAt(start) - 'a']++;
        this.recursion(counters, k, minutes + 1, s, start + 1, end);
        counters[s.charAt(start) - 'a']--;

        // 从 end 取
        counters[s.charAt(end) - 'a']++;
        this.recursion(counters, k, minutes + 1, s, start, end - 1);
        counters[s.charAt(end) - 'a']--;
    }

    private boolean isValid(int[] counters, int k) {

        for (int c : counters) {
            if (c < k) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TakeCharacters_6270 solution = new TakeCharacters_6270();
        System.out.println(solution.takeCharacters("aabaaaacaabc", 2));
    }
}
