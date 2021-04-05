public class Merge_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        m--;
        n--;
        while (m >= 0 || n >= 0) {
            int a = m >= 0 ? nums1[m] : Integer.MIN_VALUE;
            int b = n >= 0 ? nums2[n] : Integer.MIN_VALUE;
            if (a > b) {
                nums1[index--] = a;
                m--;
            } else {
                nums1[index--] = b;
                n--;
            }
        }
    }
}
