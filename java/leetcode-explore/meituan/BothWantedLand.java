package meituan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BothWantedLand {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), p = sc.nextInt(), q = sc.nextInt();

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < p; i++) {
            set.add(sc.nextInt());
        }

        int both = 0;
        int bWant = 0;
        for (int i = 0; i < q; i++) {
            int tmp = sc.nextInt();

            if (set.contains(tmp)) {
                both++;
                set.remove(tmp);
            } else {
                bWant++;
            }
        }

        System.out.printf("%d %d %d\n", set.size(), bWant, both);
    }
}
