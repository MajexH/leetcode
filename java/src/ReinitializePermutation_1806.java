import java.util.Arrays;

public class ReinitializePermutation_1806 {

    public int reinitializePermutation(int n) {
        // 实际上就是找变换几次可以把 位置转回去
        int res = 0;
        int onePosition = 1;
        do {
            onePosition = (onePosition % 2) == 0 ? onePosition / 2 : (n / 2 + (onePosition - 1) / 2);
            res++;
        } while (onePosition != 1);
        return res;
    }

    public int reinitializePermutationBruteForce(int n) {
        // 实际上就是找变换几次可以把 位置转回去
        int res = 1;

        int[] origin = new int[n];

        for (int i = 1, j = n / 2, k = 1; k <= n - 1; ) {
            origin[k++] = j++;
            if (k >= n - 1) break;
            origin[k++] = i++;
        }

        int[] refer = Arrays.copyOf(origin, origin.length);

        while (origin[1] != 1) {
            res++;
            origin = transfer(origin, refer);
        }
        return res;
    }

    public int[] transfer(int[] origin, int[] refer) {
        int[] res = new int[origin.length];
        // 根据 refer 交换数字
        for (int i = 1; i <= origin.length - 2; i++) {
            res[i] = origin[refer[i]];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ReinitializePermutation_1806().reinitializePermutation(2));
        System.out.println(new ReinitializePermutation_1806().reinitializePermutation(4));
        System.out.println(new ReinitializePermutation_1806().reinitializePermutation(6));
    }
}
