public class CircularArrayLoop_457 {

    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (checkCircle(nums, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCircle(int[] nums, int i) {
        int len = 0;
        int start = i;
        int next = getNext(nums, i);
        i = next;
        len++;

        if (next == -1) return false;
        // 要的是循环 不是自环 所以 next 一定要回到初始点
        while (i != start) {
            next = getNext(nums, i);
            if (len >= nums.length) return false;
            if (next == -1) return false;
            i = next;
            len++;
        }

        return len > 1;
    }

    private int getNext(int[] nums, int i) {
        int next = i + (nums[i] % nums.length);

        if (next >= nums.length) {
            next = next - nums.length;
        }
        if (next < 0) {
            next = nums.length + next;
        }
        // 必须全为正 or 全为负数
        if (!check(nums[i], nums[next])) {
            return -1;
        }
        return next;
    }

    private boolean check(int base, int num) {
        if (base <= 0 && num <= 0) {
            return true;
        }
        return base >= 0 && num >= 0;
    }

    public static void main(String[] args) {
        // 要注意的是 可能会有数字超过的很大
        System.out.println(new CircularArrayLoop_457().circularArrayLoop(new int[]{-8,-1,1,7,2}));
        System.out.println(new CircularArrayLoop_457().circularArrayLoop(new int[]{2, -1, 1, 2, 2}));
        System.out.println(new CircularArrayLoop_457().circularArrayLoop(new int[]{2, 2, 2, 2, 2, 4, 7}));
        System.out.println(new CircularArrayLoop_457().circularArrayLoop(new int[]{-1, 2}));
        System.out.println(new CircularArrayLoop_457().circularArrayLoop(new int[]{-2, 1, -1, -2, -2}));
    }
}
