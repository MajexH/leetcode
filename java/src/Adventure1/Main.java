package Adventure1;

import java.util.Scanner;

public class Main {

    public static void recursion(char a, char b, char c, int count) {
        if (count == 0) {
            return;
        }
        recursion(a, c, b, count - 1);
        System.out.println(a + " to " + c);
        recursion(b, a ,c, count - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            scanner.useDelimiter("\n");
            int n = scanner.nextInt();
            Main.recursion('A', 'B', 'C', n);
            System.out.println();
        }
    }
}
