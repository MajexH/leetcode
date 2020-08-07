package algorithmInterview.beforeStart;

import java.util.Arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) return;
        int index = Math.min(nums1.length, m + n);
        m--;
        n--;
        while (m >= 0 || n >= 0) {
            if (index == 0) break;
            int num1 = m >= 0 ? nums1[m] : Integer.MIN_VALUE;
            int num2 = n >= 0 ? nums2[n] : Integer.MIN_VALUE;
            if (num1 > num2) {
                nums1[--index] = num1;
                m--;
            } else {
                nums1[--index] = num2;
                n--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a =new int[]{0};
        new MergeSortedArray().merge(a,1,new int[]{1},1);
        System.out.println(Arrays.toString(a));
    }
}
