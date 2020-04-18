import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesinanArray_442 {

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i] - 1) {
                swap(nums, i, nums[i] - 1);
                // 交换完毕 可能直接就交换到位置上了
                if (i == nums[i] - 1) break;
                // 如果买有交换到位置上 就会有问题 说明是有重复的
                if (nums[i] == nums[nums[i] - 1]) {
                    // 重复
                    res.add(nums[i]);
                    break;
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        System.out.println(new FindAllDuplicatesinanArray_442().findDuplicates(new int[]{ 2,1 }));
    }
}
