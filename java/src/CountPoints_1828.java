public class CountPoints_1828 {

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            for (int[] point : points) {
                if (can(point, queries[i])) {
                    res[i]++;
                }
            }
        }
        return res;
    }

    private boolean can(int[] point, int[] query) {
        int x = point[0] - query[0], y = point[1] - query[1], r = query[2];
        return x * x + y * y <= r * r;
    }
}
