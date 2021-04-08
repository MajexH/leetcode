import java.util.PriorityQueue;

public class MinimumSize_1760 {

    // 二分查找 二分的范围是返回的最小结果
    // 即最小代价
    public int minimumSize(int[] nums, int maxOperations) {
        // nums 中最大的数为 j 的大小
        int i = 1, j = 1000000000;
        int res = 0;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (check(nums, mid, maxOperations)) {
                j = mid - 1;
                res = mid;
            } else {
                i = mid + 1;
            }
        }
        return res;
    }

    // 检查当前遍历到的 mid 的状态 能不能在 maxOperations 的限制下达到
    public boolean check(int[] nums, int mid, int maxOperations) {
        int res = 0;
        for (int num : nums) {
            if (num % mid == 0) {
                res += num / mid - 1;
            } else {
                res += num / mid;
            }
        }
        return res <= maxOperations;
    }

    // bruteforce 模拟的方法 通过对递归的方法对最大数进行不停的分隔 得到最后的结果
    public int minimumSizeBruteForce(int[] nums, int maxOperations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            pq.add(num);
        }
        return recursion(pq, maxOperations);
    }

    public int recursion(PriorityQueue<Integer> pq, int operations) {
        assert !pq.isEmpty();
        if (operations == 0) return pq.peek();
        int max = pq.poll();
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= max / 2; i++) {
            int other = max - i;
            pq.add(i);
            pq.add(other);
            res = Math.min(res, recursion(pq, operations - 1));
            pq.remove(i);
            pq.remove(other);
        }
        pq.add(max);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumSize_1760().minimumSize(new int[]{9}, 2));
        System.out.println(new MinimumSize_1760().minimumSize(new int[]{2, 4, 8, 2}, 4));
        System.out.println(new MinimumSize_1760().minimumSize(new int[]{7, 17}, 2));
    }
}
