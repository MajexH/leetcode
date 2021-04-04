public class MaxDistToClosest_849 {

    public int maxDistToClosest(int[] seats) {
        int res = 0;
        int preIndexes = -1;
        // 一次遍历即可
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (preIndexes == -1) {
                    res = i;
                } else {
                    int mid = (preIndexes + i) / 2;
                    res = Math.max(res, Math.min(mid - preIndexes, i - mid));
                }
                preIndexes = i;
            }
        }
        if (preIndexes != -1) {
            res = Math.max(res, seats.length - preIndexes - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxDistToClosest_849().maxDistToClosest(new int[]{1, 1, 0, 1, 1}));
        System.out.println(new MaxDistToClosest_849().maxDistToClosest(new int[]{1, 0, 0, 0}));
        System.out.println(new MaxDistToClosest_849().maxDistToClosest(new int[]{0, 1}));
    }
}
