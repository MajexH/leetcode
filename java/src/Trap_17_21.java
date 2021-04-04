public class Trap_17_21 {

    // 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int res = 0;
        int[] left = new int[height.length + 1];
        int[] right = new int[height.length + 1];

        for (int i = 1; i <= height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }

        for (int j = height.length - 2; j >= 0; j--) {
            right[j] = Math.max(right[j + 1], height[j + 1]);
        }

        for (int i = 0; i < height.length; i++) {
            int tmp = Math.min(left[i], right[i]) - height[i];
            if (tmp >= 0) res += tmp;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Trap_17_21().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
