import java.math.BigInteger;
import java.util.Scanner;

public class Base3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int left = scanner.nextInt(), right = scanner.nextInt();

        int res = 0;
        // 模拟做是不行的
//        while (left <= right) {
//            BigInteger temp = new BigInteger("0");
//            for (int i = 1; i <= left; i++) {
//                temp = temp.add(BigInteger.valueOf(i));
//            }
//            if (temp.mod(BigInteger.valueOf(3)).equals(BigInteger.valueOf(0))) res++;
//            left++;
//        }
//        System.out.println(res);

        while (left <= right) {
            if ((left % 3 == 0) || (left + 1) % 3 == 0) res++;
            left++;
        }
        System.out.println(res);
    }
}
