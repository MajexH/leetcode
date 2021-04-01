import java.util.Deque;
import java.util.LinkedList;

public class MaximumSwap_670 {

    // 交换一次数字之后 形成的最大结果
    public int maximumSwap(int num) {
        // 其实就是找到下一个更大的排列
        int rem = num;
        Deque<Integer> nums = new LinkedList<>();

        while (num > 0) {
            nums.addLast(num % 10);
            num /= 10;
        }
        int[] arr = new int[nums.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums.removeLast();
        }

        // 找到逆序的地方
        int i = 0;
        while (i < arr.length - 1 && arr[i] >= arr[i + 1]) {
            i++;
        }
        // 完全逆序 说明自己是最大的
        if (i == arr.length - 1) return rem;

        int j = i + 1;
        int max = j;
        // 找到后面最大的 且位置更靠后的
        while (j < arr.length) {
            if (arr[max] <= arr[j]) {
                max = j;
            }
            j++;
        }
        // 跟 头交换
        if (arr[max] > arr[0]) {
            swap(arr, 0, max);
        } else {
            // 跳过 i 相等的阶段 因为会出现 999000001 那么肯定是把最前面的 0 与 1 交换最合适
            while (i >= 1 && arr[i - 1] == arr[i]) {
                i--;
            }
            swap(arr, i, max);
        }
        int res = 0;

        for (int k : arr) {
            res = res * 10 + k;
        }
        return res;
    }

    public void swap(int[] nums, int i, int j) {
        if (nums[i] == nums[j]) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSwap_670().maximumSwap(999901));
        System.out.println(new MaximumSwap_670().maximumSwap(98368));
        System.out.println(new MaximumSwap_670().maximumSwap(2736));
        System.out.println(new MaximumSwap_670().maximumSwap(9973));
    }
}
