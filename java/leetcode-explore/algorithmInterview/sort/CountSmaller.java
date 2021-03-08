package algorithmInterview.sort;

import java.util.ArrayList;
import java.util.List;

public class CountSmaller {

    // 其实就是找逆序数对
    public List<Integer> countSmaller(int[] nums) {
        int[] index = new int[nums.length];
        List<Integer> res = new ArrayList<>(nums.length);

        for (int i = 0; i < index.length; i++) {
            index[i] = i;
            res.add(0);
        }

        mergeSort(nums, 0, nums.length - 1, index, res);

        return res;
    }

    public void mergeSort(int[] nums, int i, int j, int[] index, List<Integer> res) {
        if (i >= j) return;
        int mid = i + (j - i) / 2;
        mergeSort(nums, i, mid, index, res);
        mergeSort(nums, mid + 1, j, index, res);
        merge(nums, i, mid, j, index, res);
    }

    public void merge(int[] nums, int start, int mid, int end, int[] index, List<Integer> res) {
        int[] tmp = new int[end - start + 1];
        int[] tmpIndexes = new int[end - start + 1];

        int i = start, j = mid + 1;
        int count = 0;
        while (i <= mid && j <= end) {
            if (nums[i] > nums[j]) {
                tmp[count] = nums[j];
                tmpIndexes[count++] = index[j++];
            } else {
                // 说明对 i 来说 j 之前的都是逆序的
                // 因为 从 mid + 1 -> j - 1 都是小于 nums[i] 的
                tmp[count] = nums[i];
                res.set(index[i], res.get(index[i]) + j - mid - 1);
                tmpIndexes[count++] = index[i++];
            }
        }

        while (i <= mid) {
            tmp[count] = nums[i];
            res.set(index[i], res.get(index[i]) + j - mid - 1);
            tmpIndexes[count++] = index[i++];
        }

        while (j <= end) {
            tmp[count] = nums[j];
            tmpIndexes[count++] = index[j++];
        }

        for (int iForNums = start, iForTmp = 0; iForTmp < tmp.length; iForNums++, iForTmp++) {
            nums[iForNums] = tmp[iForTmp];
            index[iForNums] = tmpIndexes[iForTmp];
        }
    }

    public static void main(String[] args) {
        System.out.println(new CountSmaller().countSmaller(new int[]{5,2,6,1}));
    }
}
