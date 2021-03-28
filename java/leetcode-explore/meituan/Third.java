package meituan;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Third {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt(), m = sc.nextInt();
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();

            if (!map.containsKey(val)) {
                map.put(val, new int[]{i + 1, i + 1});
            } else {
                int[] tmp = map.get(val);
                tmp[1] = i + 1;
                map.put(val, tmp);
            }
        }

        for (int i = 0; i < m; i++) {
            int find = sc.nextInt();
            if (!map.containsKey(find)) {
                out.write(String.valueOf(0));
                out.newLine();
                continue;
            }
            int[] indexes = map.get(find);
            out.write(String.format("%d %d", indexes[0], indexes[1]));
            out.newLine();
        }
        out.flush();
    }
}
