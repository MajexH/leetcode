package arrayandstr;

public class MaxArea {
    public int maxArea(int[] height) {
        int res = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            res = Math.max(res, (j - i) * Math.min(height[j], height[i]));
            if (height[i] < height[j]) i++;
            else j--;
        }
        return res;
    }
}
