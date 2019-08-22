package BigIntegerMultiply;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = reader.readLine().split(" ");
        int[] res = new int[temp[0].length() + temp[1].length()];

        for (int i = temp[0].length() - 1; i >= 0; i--) {
            for (int j = temp[1].length() - 1; j >= 0; j--) {
                int left = temp[0].charAt(i) - '0', right = temp[1].charAt(j) - '0';
                int result = res[i + j + 1] + left * right;
                // 进位
                res[i + j] = result / 10;
                // 余数
                res[i + j + 1] = result % 10;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < res.length; index++) {
            if (index == 0 && res[index] == 0) continue;
            builder.append(res[index]);
        }
        System.out.println(builder.toString());
    }
}
