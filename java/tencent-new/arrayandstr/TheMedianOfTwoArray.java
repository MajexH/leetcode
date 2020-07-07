package arrayandstr;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TheMedianOfTwoArray {

    // 直接排序算了
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        nums1 = Arrays.copyOf(nums1, nums1.length + nums2.length);
        System.arraycopy(nums2, 0, nums1, nums1Length, nums2.length);
        Arrays.sort(nums1);
        if (nums1.length % 2 == 1) {
            return nums1[nums1.length / 2];
        } else {
            assert nums1.length != 0;
            return (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2D;
        }
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int nums2Length = nums2.length;
        nums2 = Arrays.copyOf(nums2, nums1.length + nums2.length);
        System.arraycopy(nums1, 0, nums2, nums2Length, nums1.length);

        for (int counter = 0; counter < nums2.length; counter++) {
            int num = nums2[counter];
            // 加入大顶堆
            if (counter % 2 == 0) {
                if (minHeap.size() != 0 && num > minHeap.peek()) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(num);
                } else {
                    maxHeap.add(num);
                }

            } else {
                // 加入小顶堆
                if (maxHeap.size() != 0 && num < maxHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }

            }
        }

        if (minHeap.size() == 0 && maxHeap.size() == 0) {
            return 0D;
        } else if (minHeap.size() == 0 || nums2.length % 2 == 1) {
            return maxHeap.poll();
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2D;
        }

    }

    public static void main(String[] args) {
        System.out.println(new TheMedianOfTwoArray().findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    }
}
