public class AverageWaitingTime_1701 {

    public double averageWaitingTime(int[][] customers) {
        double waitTime = 0;
        if (customers.length == 0) return waitTime;
        // customer 已经按照非递减的顺序进行排列了
        // 记录每轮结束后 当前的时刻
        int curTime = customers[0][0];

        for (int[] customer : customers) {
            // 有可能当前的时间小于之前的时间 说明结束此次烹饪的时间为当前开始烹饪的时间 + 结束烹饪的时间
            if (curTime <= customer[0]) {
                curTime = customer[0] + customer[1];
            } else {
                curTime = curTime + customer[1];
            }
            // 中间客人等的时间为 当前的时间 减去客人到达的时间
            waitTime += curTime - customer[0];
        }
        return waitTime / customers.length;
    }

    public static void main(String[] args) {
        System.out.println(new AverageWaitingTime_1701().averageWaitingTime(new int[][]{{1, 2}, {2, 5}, {4, 3}}));
        System.out.println(new AverageWaitingTime_1701().averageWaitingTime(new int[][]{{5, 2}, {5, 4}, {10, 3}, {20, 1}}));
    }
}
