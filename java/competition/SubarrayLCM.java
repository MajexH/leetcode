package competition;

public class SubarrayLCM {

    public static void main(String[] args) {
        SubarrayLCM subarrayLCM = new SubarrayLCM();

        System.out.println(subarrayLCM.subarrayLCM(new int[]{105, 15}, 315));
        System.out.println(subarrayLCM.subarrayLCM(new int[]{3}, 2));
        System.out.println(subarrayLCM.subarrayLCM(new int[]{3, 6, 2, 7, 1}, 6));
        System.out.println(subarrayLCM.subarrayLCM(new int[]{2, 1, 1, 5}, 5));
    }

    public int subarrayLCM(int[] nums, int k) {

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length && k % nums[j] == 0; j++) {
                nums[i] = this.lcm(nums[i], nums[j]);
                res += k == nums[i] ? 1 : 0;
            }
        }

        return res;
    }

    private int lcm(int a, int b) {
        return (a * b) / this.gcd(a, b);
    }

    private int gcd(int a, int b) {
        return a % b == 0 ? b : this.gcd(b, a % b);
    }
}
