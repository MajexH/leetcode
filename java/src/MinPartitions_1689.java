public class MinPartitions_1689 {

    // 如果一个十进制数只能由 0 1 组成称其为 十-二进制数
    // 问数字 n 最少可由多少个 十-二进制数 组成
    public int minPartitions(String n) {
        int max = 0;

        for (char c : n.toCharArray()) {
            max = Math.max(c - '0', max);
            if (max == 9) return max;
        }
        return max;
    }
}
