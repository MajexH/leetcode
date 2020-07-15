package highFrequency.classic;

public class RainWater {
    public int trap(int[] height) {
        int res = 0;
        if (height == null || height.length == 0) return res;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
             left[i] = Math.max(height[i], left[i - 1]);
        }
        right[right.length - 1] = height[height.length - 1];
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }
}
