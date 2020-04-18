import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MSecond {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(), b = scanner.nextInt(),
                m = scanner.nextInt();
        long x = scanner.nextLong();

        int counter = 0;
        Set<Long> set = new HashSet<>();
        while (true) {
            x = (a * x + b) % m;
            if (!set.contains(x)) {
                set.add(x);
                counter++;
            } else {
                break;
            }
        }
        System.out.println(counter);
    }
}
