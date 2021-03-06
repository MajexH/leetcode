import java.util.*;

public class NextGreaterElement_496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 可以先求出 nums2 的下一个最大元素

        // 单调栈的结果
        int[] stackRes = new int[nums2.length];
        // 单调栈上不存的位置为 -1
        Arrays.fill(stackRes, -1);
        // 保存 nums2 中 num 与 index 关系 因为无重复
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
            // 遍历单调栈
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                // 栈中保存的路径一定是比 nums2[i] 小的 所以第一个大于它的数字一定是 nums2[i]
                stackRes[stack.pop()] = nums2[i];
            }
            stack.push(i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = stackRes[map.get(nums1[i])];
        }
        return res;
    }
}
