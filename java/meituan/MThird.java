import java.util.Arrays;
import java.util.Scanner;

public class MThird {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        // 有重复就不一定了
        Arrays.sort(nums);
        int divide;

        if (m % n == 0) {
            divide = m / n - 1;
        } else {
            divide = m / n;
        }
        int counter = 0, counter1 = 0;
        for (int num : nums) {
            if (nums[divide] > num) counter1++;
            if (nums[divide] == num) counter++;
        }
        int temp = (m - counter1 * n) / counter;
        System.out.format("(%d,%d)\n", nums[divide], nums[temp - 1]);
    }
}
