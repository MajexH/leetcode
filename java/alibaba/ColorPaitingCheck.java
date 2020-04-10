import java.util.Scanner;

public class ColorPaitingCheck {

    /**
     * 给一个m*n矩阵，然后给k种颜色用来给矩阵的每个点涂色，
     * 每种颜色可以用Ak次，其中Ak的总和刚好等于m*n。
     * 要求一个点与它相邻的点的颜色是不同的，问是否存在这样的染色方案。
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 代表有多少组
        int T = scanner.nextInt();
        while (T-- > 0) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            // 颜色多少
            int k = scanner.nextInt();
            int[] colors = new int[k];
            // 如果colors中有一个超过了一般的格子 意味着一定为有一个颜色需要再涂到相邻的格子 造成不满足
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < k; i++) {
                colors[i] = scanner.nextInt();
                max = Math.max(colors[i], max);
            }
            // 这是毋庸置疑的
            if (k == 1 || k > (m * n) / 2) System.out.println("No");
            else System.out.println("Yes");
        }
    }
}
