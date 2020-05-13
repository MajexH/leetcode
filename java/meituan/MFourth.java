import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MFourth {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        int mid = (n + 1) / 2;
        int[] nums = new int[n];
        int remember = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            if (nums[i] == k)
                remember = Math.min(remember, Math.abs(mid - i));
        }
        int res = Integer.MAX_VALUE;

        System.out.println(res);
    }
}
