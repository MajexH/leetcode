import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountRightSmaller_315 {

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] res = new int[n], indexes = new int[n];
        // 保存原始数组的数组 好在 res 数组中定位
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        mergeSort(nums, 0, n - 1, res, indexes);
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }

    public void mergeSort(int[] nums, int i, int j, int[] res, int[] indexes) {
        if (i >= j) return;

        int mid = i + (j - i) / 2;
        mergeSort(nums, i, mid, res, indexes);
        mergeSort(nums, mid + 1, j, res, indexes);
        merge(nums, i, mid, j, res, indexes);
    }

    public void merge(int[]nums, int start, int mid, int end, int[] res, int[] indexes) {
        int i = start, j = mid + 1;
        int[] tmp = new int[end - start + 1], tmpIndexes = new int[end - start + 1];

        int index = 0;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                // 说明 j 之前相当于 i 来说都是逆序了
                tmp[index] = nums[i];
                res[indexes[i]] += j - mid - 1;
                tmpIndexes[index++] = indexes[i++];
            } else {
                // nums[j] < nums[i]
                tmp[index] = nums[j];
                tmpIndexes[index++] = indexes[j++];
            }
        }

        while (i <= mid) {
            // 说明 j 之前相当于 i 来说都是逆序了
            tmp[index] = nums[i];
            res[indexes[i]] += j - mid - 1;
            tmpIndexes[index++] = indexes[i++];
        }

        while (j <= end) {
            tmp[index] = nums[j];
            tmpIndexes[index++] = indexes[j++];
        }

        index = 0;
        while (start <= end) {
            nums[start] = tmp[index];
            indexes[start++] = tmpIndexes[index++];
        }
    }

    public static void main(String[] args) {
        System.out.println(new CountRightSmaller_315().countSmaller(new int[]{-1, -1}));
    }
}
