package Permutations46;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void swap(List<Integer> list, int i, int j) {
        Integer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void perm(List<Integer> list, int start, List<List<Integer>> result) {
        if (start == list.size() - 1) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < list.size(); i++) {
            if (i == start || !list.get(i).equals(list.get(start))) {
                swap(list, start, i);
                perm(list, start + 1, result);
                swap(list, start, i);
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i: nums) {
            list.add(i);
        }
        perm(list, 0, result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1};
        System.out.println(permute(nums));
    }
}
