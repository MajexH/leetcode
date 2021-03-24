import java.util.Arrays;

public class MinElements_1785 {

    // 最少的添加元素 其中添加的元素 满足 abs(num) <= limit 而且 添加完后 sum(nums) == goal
    public int minElements(int[] nums, int limit, int goal) {
        // 求和 看和 goal 还差多少 然后往里面添加数字
        // 因为计算的是添加多少数字 所以 添加最大 or 最小的 能够对 到 goal 的贡献最大
        double sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 其实就是看能够取多少个 最大的 limit 贪心即可
        return (int) Math.ceil(Math.abs(goal - sum) / limit);
    }

    public static void main(String[] args) {
        System.out.println(new MinElements_1785().minElements(new int[]{1, -1, 1}, 3, -4));
        System.out.println(new MinElements_1785().minElements(new int[]{1, -10, 9, 1}, 100, 0));
        System.out.println(new MinElements_1785().minElements(new int[]{-4, -2, 4, 1, 4, 3}, 4, 521834986));
    }
}
