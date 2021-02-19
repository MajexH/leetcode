import java.util.Scanner;

public class NovemberFirst {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        String str = sc.next();
        int first = 0;
        int last = length - 1;
        boolean foundM = false;
        boolean foundT = false;
        // 前后分别找
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == 'M') {
                foundM = true;
            }
            if (foundM && str.charAt(i) == 'T') {
                first = i + 1;
                break;
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            if (str.charAt(i) == 'T') {
                foundT = true;
            }
            if (foundT && str.charAt(i) == 'M') {
                last = i;
                break;
            }
        }

        System.out.println(str.substring(first, last));
    }
}
