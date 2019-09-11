package ContainerWithMostWater11;

public class Solution {

    public int maxArea(int[] height) {
        int resMax = 0, i = 0, j = height.length - 1;
        while (i < j) {
            resMax = Math.max(resMax, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return resMax;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{ 1,8,6,2,5,4,8,3,7 }));
    }
}
