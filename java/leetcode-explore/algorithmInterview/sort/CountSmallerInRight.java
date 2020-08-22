package algorithmInterview.sort;

import java.util.*;
import java.util.stream.Collectors;

public class CountSmallerInRight {

    public void mergeSort(int[] nums, int i, int j, int[] indexes, int[] res) {
        if (i >= j) return;
        int mid = (i + j) / 2;
        mergeSort(nums, i, mid, indexes, res);
        mergeSort(nums, mid + 1, j, indexes, res);
        merge(nums, i, mid, j, indexes, res);
    }

    // 通过 indexes 数组找到当前数字在原始的数组中的位置 即定位到 res 中的位置
    public void merge(int[] nums, int start, int mid, int end, int[] indexes, int[] res) {
        int[] temp = new int[end - start + 1];
        int[] tempIndexes = new int[end - start + 1];
        int i = start, j = mid + 1, counter = 0;
        while (i <= mid && j <= end) {
            if (nums[i] > nums[j]) {
                temp[counter] = nums[j];
                // 修改 indexes 的顺序
                tempIndexes[counter++] = indexes[j++];
            } else {
                // 这个地方找到逆序所有的对数 所以需要在这儿统计逆序对数
                temp[counter] = nums[i];
                // 找到了逆序对数 需要加到原始位置的上面
                res[indexes[i]] += j - mid - 1;
                tempIndexes[counter++] = indexes[i++];
            }
        }
        while (i <= mid) {
            temp[counter] = nums[i];
            res[indexes[i]] += j - mid - 1;
            tempIndexes[counter++] = indexes[i++];
        }
        while (j <= end) {
            temp[counter] = nums[j];
            tempIndexes[counter++] = indexes[j++];
        }
        System.arraycopy(temp, 0, nums, start, end - start + 1);
        System.arraycopy(tempIndexes, 0, indexes, start, end - start + 1);
    }

    /**
     * 实际上这个问题是计算逆序数对因为 统计后面比自己小的数量 实际上就是 当前数 跟后面的逆序数的大小的比值
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        // 表示每个数字的原始下标 与 nums 的下标 一一对应
        int[] indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[i] = i;
        }
        // 返回的 counts 数组
        int[] res = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, indexes, res);
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }

    /**
     * 给定一个整数数组 nums，按要求返回一个新数组 counts。
     * 数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
     * 超时了
     * 这个解法不好的地方在于 我除了去遍历 map 里面的数值 还有一个 红黑树维护的开销
     * 实际上是一个 o(n*k*lnk) 的开销
     * @param nums
     * @return
     */
    public List<Integer> countSmallerFail(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        // dp[i] 表示右边的数小于
        int[] dp = new int[nums.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int max = 0;
            for (int key : map.headMap(nums[i], false).keySet()) {
                max += map.get(key);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            dp[i] = max;
        }
        return Arrays.stream(dp).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(new CountSmallerInRight().countSmaller(new int[]{5,2,6,1}));
    }
}
