import java.util.PriorityQueue;

public class KthLargestElementinanArray_215 {

    public int findKthLargestWithPartition(int[] nums, int k) {
        int start = 0, end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != k - 1) {
            if (index < k - 1) {
                start = index + 1;
            } else if (index > k - 1){
                end = index - 1;
            }
            index = partition(nums, start, end);
        }
        return nums[index];
    }

    // 采用PriorityQueue
    public int findKthLargest(int[] nums, int k) {
        // 小顶堆 默认就是小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int num : nums) {
            if (heap.size() < k) {
                heap.add(num);
            } else if (num > heap.peek()) {
                heap.poll();
                heap.add(num);
            }
            System.out.println(heap);
        }
        return heap.peek();
    }

    public int partition(int[] nums, int start, int end) {
        int base = nums[start];
        int i = start, j = end + 1;
        while (true) {
            while (++i <= end && base < nums[i]) if (i == end) break;
            while (base > nums[--j]) if (start == j) break;
            if (i >= j) break;
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

    public static void main(String[] args) {
        System.out.println(new KthLargestElementinanArray_215().findKthLargest(new int[]{ 3,2,1,5,6,4 }, 2));
    }
}
