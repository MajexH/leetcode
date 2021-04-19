import java.util.Arrays;

public class MaximumWealth_1672 {

    public int maximumWealth(int[][] accounts) {
        int max = 0;

        for (int[] tmp : accounts) {
            max = Math.max(max, Arrays.stream(tmp).sum());
        }
        return max;
    }
}
