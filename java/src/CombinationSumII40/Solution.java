package CombinationSumII40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public void mergeSort(int[] candidates, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(candidates, start, mid);
        mergeSort(candidates, mid + 1, end);
        merge(candidates, start, mid + 1, end);
    }

    public void merge(int[] array, int start, int mid, int end) {
        int index = 0, midRecord = mid - 1, startRecord = start;
        int[] temp = new int[end - start + 1];
        while (start <= midRecord && mid <= end) {
            if (array[start] < array[mid]) temp[index++] = array[start++];
            else temp[index++] = array[mid++];
        }
        while (start <= midRecord) {
            temp[index++] = array[start++];
        }
        while (mid <= end) {
            temp[index++] = array[mid++];
        }
        for (int i = 0, j = startRecord; i < temp.length; i++, j++) {
            array[j] = temp[i];
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        mergeSort(candidates, 0, candidates.length - 1);
        List<List<Integer>> res = new ArrayList<>();
        recursion(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    public void recursion(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // jump over same number
            if (i != start) {
                while (i < candidates.length && candidates[i] == candidates[i - 1]) {
                    i++;
                }
                if (i >= candidates.length) break;
            }
            temp.add(candidates[i]);
            recursion(candidates, target - candidates[i], res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{10,1,2,7,6,1,5};
        System.out.println(new Solution().combinationSum2(array, 8));
    }
}
