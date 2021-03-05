package xiecheng;

public class MaxProduct {

    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(max * num, num);
            min = Math.min(min * num, num);
            res = Math.max(max, res);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
