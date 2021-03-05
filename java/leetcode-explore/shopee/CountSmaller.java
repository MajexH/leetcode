package shopee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CountSmaller {

    // 统计右边比自己小的数 实际上说的是 统计右边的逆序数对有多少个 并且返回一个 List
    public List<Integer> countSmaller(int[] nums) {
        int[] indexes = new int[nums.length];
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[i] = i;
        }
        mergeSort(nums, 0, nums.length - 1, indexes, res);
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }

    public void mergeSort(int[] nums, int start, int end, int[] indexes, int[] res) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid, indexes, res);
        mergeSort(nums, mid + 1, end, indexes, res);
        merge(nums, start, mid, end, indexes, res);
    }

    public void merge(int[] nums, int start, int mid, int end, int[] indexes, int[] res) {
        int[] tmp = new int[end - start + 1];
        int[] tmpIndex = new int[end - start + 1];
        int index = 0;
        int i = start, j = mid + 1;
        while (i <= mid && j <= end) {
            if (nums[i] > nums[j]) {
                tmp[index] = nums[j];
                tmpIndex[index++] = indexes[j++];
            } else {
                tmp[index] = nums[i];
                // j 之前的都是逆序的 所以 之前的都是小于 i 的 不包括 j 自己
                res[indexes[i]] += j - mid - 1;
                tmpIndex[index++] = indexes[i++];
            }
        }
        while (i <= mid) {
            tmp[index] = nums[i];
            // j 之前的都是逆序的 所以 之前的都是小于 i 的 不包括 j 自己
            res[indexes[i]] += j - mid - 1;
            tmpIndex[index++] = indexes[i++];
        }
        while (j <= end) {
            tmp[index] = nums[j];
            tmpIndex[index++] = indexes[j++];
        }
        System.arraycopy(tmp, 0, nums, start, end - start + 1);
        System.arraycopy(tmpIndex, 0, indexes, start, end - start + 1);
    }

    public List<Integer> countSmallerBruteForce(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int smaller = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) smaller++;
            }
            res.add(0, smaller);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CountSmaller().countSmaller(new int[]{0,2,1}));
    }
}
