import java.util.Arrays;

public class MaximumElementAfterDecrementingAndRearranging_1846 {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        if (arr.length == 0) return 0;
        Arrays.sort(arr);
        arr[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) <= 1) continue;
            arr[i] = arr[i - 1] + 1;
        }

        return arr[arr.length - 1];
    }
}
