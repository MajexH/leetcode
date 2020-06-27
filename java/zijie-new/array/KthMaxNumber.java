package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author majexh
 */
public class KthMaxNumber {

    public int findKthLargest(int[] nums, int k) {
//        return usePriorityQueue(nums, k);
        int start = 0, end = nums.length - 1;
        int index = partition(nums, start, end);
        while (k - 1 != index) {
            if (index > k - 1) {
                end = index - 1;
            } else if (index < k - 1) {
                start = index + 1;
            } else {
                return nums[k - 1];
            }
            index = partition(nums, start, end);
        }
        return nums[k - 1];
    }

    public int partition1(int[] nums, int start, int end) {
        int base = nums[start];
        int i = start, j = end + 1;
        while (true) {
            while (++i < nums.length && nums[i] < base) if (i == end) break;
            while (--j >= 0 && nums[j] > base) if (j == start) break;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
    }

    /**
     * 利用快排的 partition
     */
    public int partition(int[] nums, int start, int end) {
        // 用第一个数作为分隔
        int base = nums[start];
        int i = start, j = end + 1;
        while (true) {
            // 防止越界
            while (++i < nums.length && nums[i] > base) {
                if (i >= end) {
                    break;
                }
            }
            while (--j >= 0 && nums[j] < base) {
                if (j <= start) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int usePriorityQueue(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else {
                if (minHeap.size() > 0 && num > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(num);
                }
            }
        }
        if (minHeap.size() > 0) {
            return minHeap.poll();
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new KthMaxNumber().findKthLargest(new int[]{ 2,1 }, 1));
    }
}
