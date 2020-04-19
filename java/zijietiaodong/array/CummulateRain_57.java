package array;

public class CummulateRain_57 {

    public int trap(int[] height) {
        int res = 0;
        if (height == null || height.length == 0) return res;
        // 一个节点能够积累的雨水量是由其左边的最大高度 和 右边的最大高度 和自己的高度决定的
        // leftMaxs 保存小于 i 节点的最大高度
        int[] leftMaxs = new int[height.length];
        int[] rightMaxs = new int[height.length];
        leftMaxs[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMaxs[i] = Math.max(height[i], leftMaxs[i - 1]);
        }
        rightMaxs[rightMaxs.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMaxs[i] =  Math.max(height[i], rightMaxs[i + 1]);
        }

        for (int i = 0; i < height.length; i++) {
            res += Math.min(leftMaxs[i], rightMaxs[i]) - height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CummulateRain_57().trap(new int[]{
                0,1,0,2,1,0,1,3,2,1,2,1
        }));
    }
}
