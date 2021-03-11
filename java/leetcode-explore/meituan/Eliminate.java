package meituan;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Eliminate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt(), y = sc.nextInt();

        int[] credits = new int[n];
        for (int i = 0; i < n; i++) {
            credits[i] = sc.nextInt();
        }

        // 晋级和淘汰的人数均在 [x,y] 之间
        // 假设晋级的人有 m 个
        // y >= m >= x  ( y >= n - m >= x )  => (n - x >= m >= n - y)
        // 那么要求分数线最低 也就意味着 晋级的人要更多 即取交集中的最大值

        // 没有交集 意味着不可能
        if (n - x < x || n - y > y) {
            System.out.println(-1);
            return;
        }

        int maxPeople = 0;

        // [n-y,n-x] 在 [x,y] 中间
        if (n - y >= x && n - y <= y) {
            maxPeople = n - y;
        } else {
            maxPeople = n - x;
        }

        // 得到了晋级的人数 那么就可以划出分数线
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int credit : credits) {
            pq.add(credit);
            // 要使得大于分数线的人晋级 所以要多算一个
            if (pq.size() > maxPeople + 1) pq.poll();
        }
        System.out.println(pq.poll());
    }
}
