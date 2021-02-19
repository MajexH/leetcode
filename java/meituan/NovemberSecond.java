import java.util.Scanner;

public class NovemberSecond {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] choices = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                choices[i][j] = sc.nextInt();
            }
        }

        boolean[] choosed = new boolean[n];
        int[] choose = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!choosed[choices[i][j] - 1]) {
                    choose[i] = choices[i][j] - 1;
                    choosed[choices[i][j] - 1] = true;
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(choose[i] + 1);
            System.out.print(" ");
        }
        System.out.println();
    }
}
