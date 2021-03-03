import java.util.Arrays;

public class CountBits_338 {

    // 有一种方法不用去计算 pow 只需要迭代更新 base 值即可
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        int base = 1;
        for (int i = 1; i < res.length; i++) {
            // 因为 i & (i - 1) 可以把最右边的 1 变为 0 所以用这个判断 2 ^ n
            if ((i & (i - 1)) == 0) {
                base = i;
                res[i] = 1;
                continue;
            }
            res[i] = res[i - base] + 1;
        }

        return res;
    }

    // 计算 0 <= i <= num 中每个 i 中的二进制中 1 的个数
    public int[] countBitsCountingPow(int num) {
        int[] res = new int[num + 1];
        // 0 没有 1
        res[0] = 0;
        int index = 0;
        for (int i = 1; i < res.length; i++) {
            if (i == Math.pow(2, index)) {
                // 2 ^ n 一定为 1
                res[i] = 1;
                index++;
                continue;
            }
            int base = (int) Math.pow(2, index - 1);
            res[i] = res[i - base] + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountBits_338().countBits(2)));
        System.out.println(Arrays.toString(new CountBits_338().countBits(5)));
        System.out.println(Arrays.toString(new CountBits_338().countBits(10)));
    }
}
