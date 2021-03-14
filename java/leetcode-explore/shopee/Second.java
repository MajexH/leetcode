package shopee;

import java.util.Arrays;
import java.util.Scanner;

public class Second {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        // 输入可能不符合上述的格式
        String[] lines = s.split("\\\\n");
        for (String line : lines) {
            String[] strs = line.split("\\\\t");
            if (strs.length != 2) {
                System.out.println("null,null");
                continue;
            }
            try {
                if (strs[1].startsWith("0x")) {
                    System.out.printf("%s,%d\n", strs[0], Integer.valueOf(strs[1].substring(2), 16));
                } else if (Character.isDigit(strs[1].charAt(0))) {
                    System.out.printf("%s,%d\n", strs[0], Integer.valueOf(strs[1], 10));
                } else {
                    System.out.printf("%s,%s\n", strs[0], null);
                }
            } catch (Exception ig) {
                System.out.printf("%s,%s\n", null, null);
            }
        }
    }
}
