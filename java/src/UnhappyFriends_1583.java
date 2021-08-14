import java.util.HashMap;
import java.util.Map;

public class UnhappyFriends_1583 {

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        // format pairs 到一维数组
        int[] formattedPairs = new int[n];
        for (int[] pair : pairs) {
            formattedPairs[pair[0]] = pair[1];
            formattedPairs[pair[1]] = pair[0];
        }
        // format preferences 到 map 这样好拿到亲近程度
        Map<Integer, Integer>[] preferencesMap = new HashMap[n];
        for (int i = 0; i < preferences.length; i++) {
            preferencesMap[i] = new HashMap<>();
            for (int j = 0; j < preferences[i].length; j++) {
                preferencesMap[i].put(preferences[i][j], j);
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            // 人 和 配对的人
            int x = i, y = formattedPairs[i];
            for (int j = 0 ; j < n; j++) {
                if (i == j) continue;
                int u = j, v = formattedPairs[j];
                // 判断 x 是否开心
                int xu = preferencesMap[x].get(u);
                int xy = preferencesMap[x].get(y);

                int ux = preferencesMap[u].get(x);
                int uv = preferencesMap[u].get(v);
                // 不开心
                if (xu < xy && ux < uv) {
                    res++;
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println(new UnhappyFriends_1583().unhappyFriends(4, new int[][]{
                {1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}
        }, new int[][]{
                {0, 1}, {2, 3}
        }));
    }
}
