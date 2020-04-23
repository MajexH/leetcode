import java.util.Arrays;

public class NumberofLongestIncreasingSubsequence_673 {

    public int findNumberOfLIS(int[] nums) {
        // 保存当前最长长度的length 以nums[i] 结尾
        int[] lengths = new int[nums.length];
        // 保存当前最长长度的数量 以nums[i] 结尾
        int[] counts = new int[nums.length];
        Arrays.fill(lengths, 1);
        Arrays.fill(counts, 1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lengths[j] >= lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    } else if (lengths[j] + 1 == lengths[i]){
                        counts[i] += counts[j];
                    }
                }
            }
            max = Math.max(max, lengths[i]);
        }
//        System.out.println(max);
//        System.out.println(Arrays.toString(lengths));
//        System.out.println(Arrays.toString(counts));
        int res = 0;
        for (int i = 0; i < lengths.length; i++) {
            if (lengths[i] == max) res += counts[i];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumberofLongestIncreasingSubsequence_673().findNumberOfLIS(new int[]{
                1
        }));
    }
}
