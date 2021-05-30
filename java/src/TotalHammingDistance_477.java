public class TotalHammingDistance_477 {

    private int humming(int a, int b) {
        int res = 0, xor = a ^ b;
        while (xor != 0) {
            xor &= (xor - 1);
            res++;
        }
        return res;
    }

    // o(n^2) 的解法 超时 因为数据太大
    public int totalHammingDistanceBruteForce(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                res += humming(nums[i], nums[j]);
            }
        }
        return res;
    }

    // 非 o(n^2) 的解法
    // 用一个结构体来描述某一位上的 1 0 的数量
    private static class Pair {
        int one;
        int zero;
    }
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        Pair[] pairs = new Pair[32];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new Pair();
        }

        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                int t = num & (1 << i);
                if (t == 0) {
                    pairs[i].zero += 1;
                } else {
                    pairs[i].one += 1;
                }
            }
        }

        for (Pair p : pairs) {
            res += p.one * p.zero;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new TotalHammingDistance_477().totalHammingDistance(new int[]{4,14,2}));
    }
}
