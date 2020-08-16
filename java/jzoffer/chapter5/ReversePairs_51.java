package chapter5;

public class ReversePairs_51 {

    public int mergeSort(int[] nums, int start, int end) {
        if (start >= end) return 0;
        int mid = (start + end) / 2;
        int left = mergeSort(nums, start, mid);
        int right = mergeSort(nums, mid + 1, end);
        return left + right + merge(nums, start, mid, end);
    }

    public int merge(int[] nums, int start, int mid, int end) {
        int counter = 0;
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, index = 0;
        while (i <= mid && j <= end) {
            if (nums[i] > nums[j]) {
                temp[index] = nums[j];
                j++;
            } else {
                // 这个时候说明 从 mid -> j 这个里面 先进去的数 都是逆序的
                counter += j - mid - 1;
                temp[index] = nums[i];
                i++;
            }
            index++;
        }

        while (i <= mid) {
            // 同理 这儿也是
            counter += j - mid - 1;
            temp[index] = nums[i];
            i++;
            index++;
        }

        while (j <= end) {
            temp[index] = nums[j];
            j++;
            index++;
        }


        for (int num : temp) {
            nums[start++] = num;
        }

        return counter;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(new ReversePairs_51().reversePairs(new int[]{1,3,2,3,1}));
    }
}
