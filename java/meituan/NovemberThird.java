import java.util.*;

public class NovemberThird {

    private static List<Integer> pathes = new ArrayList<>();

    // 寻找两个点之间的最短长度
    public static void dfs(int x, int y, Map<Integer, Set<Integer>> map, boolean[] traveled, List<Integer> path) {
        traveled[x - 1] = true;
        path.add(x);
        if (x == y) {
            if (pathes.size() == 0 || pathes.size() > path.size()) {
                pathes = new ArrayList<>(path);
            }
            path.remove(path.size() - 1);
            return;
        }

        if (map.containsKey(x)) {
            for (int temp : map.get(x)) {
                if (!traveled[temp - 1]) {
                    // 撞见了
                    dfs(temp, y, map, traveled, path);
                }
            }
        }
        path.remove(path.size() - 1);
    }


    // 单元最短路
    public static int[] shortest(int start, Map<Integer, Set<Integer>> map, boolean[] traveled) {
        int[] res = new int[traveled.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int top = queue.remove();
            traveled[top - 1] = true;
            if (map.containsKey(top)) {
                for (int adj : map.get(top)) {
                    if (!traveled[adj - 1]) {
                        if (res[adj - 1] == 0) {
                            res[adj - 1] = res[top - 1] + 1;
                        } else {
                            res[adj - 1] = Math.min(res[adj - 1], res[top - 1] + 1);
                        }
                        queue.add(adj);
                    }
                }
            }
        }
        return res;
    }

    // 我的理解是先找到追击的人到这个点的最短距离
    // 然后看中间是否有一个点能够满足 追击的人到这个点的距离 小于 被追击的人到这个点的距离 且从这个点能跑最远
    // 如果以上都不行 那么肯定是 追击的最短距离 + 没有这个点的跑的最长距离
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int p = sc.nextInt(), v = sc.nextInt();
            if (map.containsKey(p)) {
                map.get(p).add(v);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(v);
                map.put(p, set);
            }
            if (map.containsKey(v)) {
                map.get(v).add(p);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(p);
                map.put(v, set);
            }
        }
        pathes = new ArrayList<>();
        dfs(x, y, map, new boolean[n], new ArrayList<>());
        int[] a = shortest(x, map, new boolean[n]);
        int[] b = shortest(y, map, new boolean[n]);

        

        for (int path : pathes) {
            if (path == x || path == y) {
                continue;
            }
            if (a[path - 1] > b[path - 1]) {

            }
        }
    }
}
