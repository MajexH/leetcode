import java.util.Arrays;

public class GasStation_134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0 || cost.length == 0) return -1;
        int gasSum = Arrays.stream(gas).boxed().reduce(Integer::sum).get();
        int costSum = Arrays.stream(cost).boxed().reduce(Integer::sum).get();

        if (gasSum < costSum) return -1;
        // 这个时候 gasSum >= costSum 一定会有一个站点成为解
        int curStation = 0;
        int curGas = 0;
        for (int i = curStation; i < gas.length; i++) {
            curGas = curGas + gas[i] - cost[i];
            // 因为一定有解 而从最开始的站点出发 明显油不够
            // 而总体的油是够的，因此选取下一个站点作为出发点
            // 然后可能就能到
            if (curGas < 0) {
                // 选择从下一个站点出发
                curStation = i + 1;
                curGas = 0;
            }
        }

        return curStation;
    }

    public static void main(String[] args) {
        System.out.println(new GasStation_134().canCompleteCircuit(new int[]{ 1,2,3,4,5 }, new int[]{ 3,4,5,1,2 }));
    }
}
