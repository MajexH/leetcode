import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class NetEaseThird {

    public static int max = 0;

    public static void dfs(int k, LinkedList<Integer> trace, LinkedList[] map, int start) {
        if (k == 0) {
            max = Math.max(max, new HashSet<>(trace).size());
            return;
        }
        LinkedList<Integer> adjacents = map[start];
        // 相当于弹栈的时候 把不该弹出的 因为有环 弹出了
        for (int adjacent : adjacents) {
            trace.add(adjacent);
            dfs(k - 1, trace, map, adjacent);
            trace.removeLast();
        }

    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), k = sc.nextInt();
        LinkedList[] map = new LinkedList[n];
        for (int i = 0; i < n - 1; i++) {
            int target = sc.nextInt();
            if (map[i + 1] == null) {
                map[i + 1] = new LinkedList<Integer>();
            }
            if (map[target] == null) {
                map[target] = new LinkedList<Integer>();
            }
            map[i + 1].add(target);
            map[target].add(i + 1);
        }

        max = 0;
        LinkedList<Integer> trace = new LinkedList<>();
        trace.add(0);
        dfs(k, trace, map, 0);
        System.out.println(max);
    }
}
