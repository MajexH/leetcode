package chapter5;

// 寻找数组的逆序数对
public class ReverseOrder_51 {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int i, int j) {
        if (i >= j) return 0;
        int mid = (i + j) / 2;
        int left = mergeSort(nums, i, mid);
        int right = mergeSort(nums, mid + 1, j);
        // 因为一个逆序数对由三部分组成
        // 第一部分是 left 里面的逆序数对
        // 第二部分的是 right 里面的逆序数对
        // 第三部分是 跨越 left right 区域里面的逆序数对
        return left + right + merge(nums, i, mid, j);
    }

    public int merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, index = 0;
        // 本次 merge 中的逆序数对的多少
        int res = 0;
        while (i <= mid && j <= end) {
            if (nums[i] > nums[j]) {
                temp[index++] = nums[j++];
            } else {
                // 这儿可以计算逆序数对 因为这个时候相当于从右半部分里面放在 temp 里面的数都是小于 nums[i] 的
                // 即 nums[i] 却比 从 mid + 1 开始的到j的右半部分里面的值 大 说明是逆序的
                // 加上这个逆序的长度即可
                res += j - mid - 1;
                temp[index++] = nums[i++];
            }
        }
        while (i <= mid) {
            // 同上 这个地方也是需要加上逆序的长度
            res += j - mid - 1;
            temp[index++] = nums[i++];
        }
        while (j <= end) {
            temp[index++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, start, temp.length);
        return res;
    }
}
