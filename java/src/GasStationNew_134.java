import java.util.Arrays;

public class GasStationNew_134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) return -1;

        int gasSum = Arrays.stream(gas).boxed().reduce(Integer::sum).get();
        int costSum = Arrays.stream(cost).boxed().reduce(Integer::sum).get();

        if (gasSum < costSum) return -1;

        int curGas = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curGas += gas[i];
            // 说明从之前出发的站点是不可能的
            // 然后从下一个站点出发
            if (curGas < cost[i]) {
                curGas = 0;
                start = i + 1;
            } else {
                curGas -= cost[i];
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(new GasStationNew_134().canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }
}
