package meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ModifyArticle {
    // 最少修改多少次让大小写数量相等

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 文章一定是由偶数长度
        String str = reader.readLine();

        int small = 0, big = 0;

        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') small++;
            if (c >= 'A' && c <= 'Z') big++;
        }

        // 计算差值
        int diff = Math.abs(small - big);
        System.out.println(diff / 2);
    }
}
