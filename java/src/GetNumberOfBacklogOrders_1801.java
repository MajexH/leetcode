import java.util.Comparator;
import java.util.PriorityQueue;

public class GetNumberOfBacklogOrders_1801 {

    // 积压订单中的订单总数
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> sells = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> buys = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int[] order : orders) {
            if (order[2] == 0) {
                // 采购订单
                while (!sells.isEmpty() && order[1] > 0) {
                    int[] top = sells.peek();
                    // 判断 prices
                    // 价格不匹配 直接 break
                    if (order[0] < top[0]) break;
                    // 数量更多
                    if (top[1] >= order[1]) {
                        top[1] -= order[1];
                        order[1] = 0;
                    } else {
                        // order 数量更多
                        order[1] -= top[1];
                        top[1] = 0;
                    }

                    // 弹出
                    sells.poll();
                    // 更新值
                    if (top[1] != 0) sells.add(top);
                }
                // 还剩下
                if (order[1] > 0) {
                    buys.add(order);
                }
            } else {
                // 销售订单
                // 同理
                while (!buys.isEmpty() && order[1] > 0) {
                    int[] top = buys.peek();
                    if (order[0] > top[0]) break;
                    if (top[1] >= order[1]) {
                        top[1] -= order[1];
                        order[1] = 0;
                    } else {
                        order[1] -= top[1];
                        top[1] = 0;
                    }

                    buys.poll();
                    if (top[1] != 0) buys.add(top);
                }

                if (order[1] > 0) {
                    sells.add(order);
                }
            }
        }

        int res = 0;
        for (int[] sell : sells) {
            res = (res + sell[1]) % 1000000007;
        }
        for (int[] buy : buys) {
            res = (res + buy[1]) % 1000000007;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new GetNumberOfBacklogOrders_1801().getNumberOfBacklogOrders(new int[][]{
                {16, 24, 0},
                {16, 2, 1},
                {23, 28, 1},
                {21, 6, 0},
                {17, 8, 0},
                {25, 7, 0}
        }));
    }
}
