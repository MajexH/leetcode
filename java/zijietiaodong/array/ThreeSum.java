package array;

import java.util.*;

public class ThreeSum {
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
     * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     * 采用非递归的方式超时了
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int sum = nums[i];
            int front = i + 1, end = nums.length - 1;
            while (front < end) {
                int temp = sum + nums[front] + nums[end];
                if (temp == 0) {
                    int finalI = i;
                    int finalFront = front;
                    int finalEnd = end;
                    res.add(new ArrayList<>(){{ add(nums[finalI]); add(nums[finalFront]); add(nums[finalEnd]); }});
                    // 这个地方是为了继续寻找 以i开头的数 的可能结果
                    do {
                        front++;
                    } while (front < end && nums[front] == nums[front - 1]);
                    do {
                        end--;
                    } while (front < end && nums[end] == nums[end + 1]);
                } else if (temp < 0) {
                    front++;
                } else {
                    end--;
                }
            }
        }

        return res;
    }

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
     * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     * 采用递归的方式超时了
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        recursion(nums, new ArrayList<>(), 0, 0, res, 0);
        return res;
    }

    public void recursion(int[] input, List<Integer> temp, int current, int index, List<List<Integer>> res, int start) {
        if (index == 3) {
            if (current == 0) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = start; i < input.length; i++) {
            if (i != start && input[i] == input[i - 1]) continue;
            temp.add(input[i]);
            recursion(input, temp, current + input[i], index + 1, res, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{ -1, 0, 1, 2, -1, -4 }));
    }
}
