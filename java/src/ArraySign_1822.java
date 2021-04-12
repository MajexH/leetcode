public class ArraySign_1822 {

    public int arraySign(int[] nums) {
        boolean isMinus = false;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) isMinus = !isMinus;
        }
        return isMinus ? -1 : 1;
    }
}
