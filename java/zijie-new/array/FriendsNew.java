package array;

/**
 * @author majexh
 */
public class FriendsNew {

    public void dfs(boolean[] memo, int[][] M, int index) {
       memo[index] = true;
       for (int i = 0; i < M[index].length; i++) {
           if (!memo[i] && M[index][i] == 1) {
               dfs(memo, M, i);
           }
       }
    }

    public int findCircleNum(int[][] M) {
        boolean[] memo = new boolean[M.length];
        int res = 0;
        for (int i = 0; i < M.length; i++) {
            if (!memo[i]) {
                dfs(memo, M, i);
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FriendsNew().findCircleNum(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        }));
    }
}
