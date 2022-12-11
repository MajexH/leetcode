import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangminjie
 * @since 2022/12/11
 */
public class LongestSquareStreak_6258 {

    public static void main(String[] args) {
        LongestSquareStreak_6258 solution = new LongestSquareStreak_6258();

        System.out.println(solution.longestSquareStreak(new int[]{4, 3, 6, 16, 8, 2}));

        System.out.println(solution.longestSquareStreak(new int[]{2, 3, 4, 5}));
    }

    int res = -1;

    public int longestSquareStreak(int[] nums) {
        boolean[] visited = new boolean[nums.length];

        int length = -1;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            int now = nums[i];
            int curLength = 1;
            int index;
            while ((index = this.binarySearch(nums, i + 1, nums.length - 1, now * now)) != -1) {
                curLength++;
                now = now * now;
                visited[index] = true;
            }

            if (curLength >= 2) {
                length = Math.max(length, curLength);
            }

        }

        return length;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {

        if (target > nums[end]) {
            return -1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public int longestSquareStreakWithRecursion(int[] nums) {
        this.res = -1;
        if (nums.length < 2) {
            return this.res;
        }

        Arrays.sort(nums);

        this.recursion(0, nums, new ArrayList<>());

        return this.res;
    }

    private void recursion(int index, int[] nums, List<Integer> tmp) {
        if (index >= nums.length) {

            if (tmp.size() >= 2) {
                this.res = Math.max(res, tmp.size());
            }
            return;
        }

        for (int i = index; i < nums.length; i++) {
            // 为空 或者 要为前一个数的 平方
            if (tmp.isEmpty() || nums[i] == tmp.get(tmp.size() - 1) * tmp.get(tmp.size() - 1)) {
                tmp.add(nums[i]);
                this.recursion(i + 1, nums, tmp);
                tmp.remove(tmp.size() - 1);
            } else if (tmp.get(tmp.size() - 1) * tmp.get(tmp.size() - 1) < nums[i]) {
                // 已经已经排序 所以如果数据更大 可以剪枝 后边不会有等于平方的数儿了
                break;
            }
        }
        // 没有找到
        if (tmp.size() >= 2) {
            this.res = Math.max(this.res, tmp.size());
        }
    }
}
