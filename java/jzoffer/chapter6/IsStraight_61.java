package chapter6;

import java.util.Arrays;

public class IsStraight_61 {

    // 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
    // 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);

        int numbersOfZeros = 0;
        for (int i = 0; i < nums.length && nums[i] == 0; i++) {
            numbersOfZeros++;
        }

        int gaps = 0;
        for (int i = numbersOfZeros; i < nums.length - 1; i++) {
            // 有相同数字 肯定不连续
            if (nums[i + 1] == nums[i]) return false;
            // 计算前后两个数字的 gap 查看最后的 gap 是否比 0 任意的数字小
            gaps += nums[i + 1] - 1 - nums[i];
        }
        return numbersOfZeros >= gaps;
    }
}
