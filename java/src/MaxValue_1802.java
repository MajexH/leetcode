public class MaxValue_1802 {

    // 构造一个长度为 n 的数组
    // 数组的最大和为 maxSum
    // 而且数组中的相邻数组的差值的 abs 为 1
    // 问最后 index 位置能够生成的最大数值为多少
    // 其中数组中的每个数为正整数
    public int maxValue(int n, int index, int maxSum) {
        // 因为是正整数 所以相当于每个数字至少要填上1
        int remain = maxSum - n;

        // 现在 index 位置填入的是 1
        int res = 1;
        // 然后根据剩下的数字 从 index 开始增加
        int l = index, r = index;
        // 不用扩充到 0 n - 1 位置 因为必须是正整数 所以这两个位置必须是 1 不能添加其他的数字
        while (l > 0 || r < n - 1) {
            // 在 l 到 r 之间的数字 加 1
            int len = r - l + 1;
            if (remain >= len) {
                // index 对应位置的数字 一定是在 l,r 之间的
                res += 1;
                // 因为相邻不能相差 1 所以 每次 l、r 向外增加 1 位长度
                l = Math.max(0, l - 1);
                r = Math.min(r + 1, n - 1);
                remain -= len;
            } else {
                break;
            }
        }

        // 还剩下 全部加一
        res += remain / n;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxValue_1802().maxValue(4, 2, 6));
    }
}
