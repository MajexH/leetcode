package meituan;

import java.util.Scanner;

public class SimulateMove {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();

        int p = sc.nextInt(), q = sc.nextInt();

        int[][] map = new int[n][m];

        // 记录开始点
        int curI = 0, curJ = 0;

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                switch (c) {
                    case 'S':
                        curI = i;
                        curJ = j;
                        break;
                    case '#':
                        // 表示无法通过
                        map[i][j] = -1;
                        break;
                    case 'O':
                        // 得分点
                        map[i][j] = 1;
                        break;
                    case 'X':
                        // 陷阱
                        map[i][j] = -2;
                        break;
                    default:
                        // 普通点
                        continue;
                }
            }
        }

        // 操作数
        String commands = sc.next();
        // 陷阱和得分 都只能得到一次

        int res = 0;

        for (char command : commands.toCharArray()) {
            int[] newIndex = getIJ(curI, curJ, command);
            int x = newIndex[0], y = newIndex[1];
            // 越界不动
            if (x < 0 || x >= n || y < 0 || y >= m || map[x][y] == -1) continue;

            if (map[x][y] == 1) {
                res += p;
                map[x][y] = 0;
            } else if (map[x][y] == -2) {
                res -= q;
                map[x][y] = 0;
            }
            curI = x;
            curJ = y;
        }

        System.out.println(res);
    }

    private static int[] getIJ(int curI, int curJ, char command) {
        switch (command) {
            case 'W':
                return new int[]{curI - 1, curJ};
            case 'A':
                return new int[]{curI, curJ - 1};
            case 'S':
                return new int[]{curI + 1, curJ};
            case 'D':
                return new int[]{curI, curJ + 1};
        }
        return new int[2];
    }
}
