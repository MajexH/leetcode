import java.util.HashMap;
import java.util.Map;

public class NumRabbits_781 {

    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }
        int res = 0;
        for (int key : map.keySet()) {
            int val = map.get(key);
            // 有 val 个兔子 说了 key 那么就会有 key + 1 个兔子是同一种颜色
            // 因为可能 val > key + 1 所以需要取向上的整数 表示取的兔子的不同的颜色的数量
            res += Math.ceil((double) val / (key + 1)) * (key + 1);
        }
        return res;
    }
}
