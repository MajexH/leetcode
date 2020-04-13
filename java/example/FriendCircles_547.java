public class FriendCircles_547 {

    // 每次都去遍历dfs 这样就能找到 从一个startId 开始的所有与他相连的人
    // 并且把memo[id] 置位 true 下次就不用访问了
    public void dfs(int startId, boolean memo[], int[][] M) {
        memo[startId] = true;
        for (int i = 0; i < M.length; i++) {
            if (!memo[i] && M[startId][i] == 1) {
                dfs(i, memo, M);
            }
        }
    }

    public int findCircleNum(int[][] M) {
        boolean[] memo = new boolean[M.length];
        int res = 0;
        for (int i = 1; i <= M.length; i++) {
            // memo 用来保存已经访问过的链接
            if (!memo[i - 1]) {
                dfs(i - 1, memo, M);
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FriendCircles_547().findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}
