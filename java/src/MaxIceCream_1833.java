import java.util.Arrays;

public class MaxIceCream_1833 {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        for (int cost : costs) {
            if (coins < cost) {
                break;
            }
            coins -= cost;
            res++;
        }
        return res;
    }
}
