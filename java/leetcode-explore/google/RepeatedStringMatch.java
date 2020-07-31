package google;

import java.util.Arrays;

public class RepeatedStringMatch {

    // 这个地方的子串 说明的是 顺序也相同的子串
    public int repeatedStringMatch(String A, String B) {

        int[] aMemo = new int[26];
        int[] bMemo = new int[26];
        // -1 代表这个字符不存在
        Arrays.fill(aMemo, -1);
        Arrays.fill(bMemo, -1);
        for (char a : A.toCharArray()) {
            if (aMemo[a - 'a'] == -1) aMemo[a - 'a'] = 1;
            else aMemo[a - 'a']++;
        }
        for (char b : B.toCharArray()) {
            if (bMemo[b - 'a'] == -1) bMemo[b - 'a'] = 1;
            else bMemo[b - 'a']++;
        }
        // 如果 B 含有 A 不存在的字符串 那么说明 B 不可能是 A 的子串
        for (int i = 0; i < 26; i++) {
            if (aMemo[i] == -1 && bMemo[i] != -1) {
                return -1;
            }
        }
        int counter = 1;
        StringBuilder move = new StringBuilder(A);
        // 这个时候出来 一定能够知道 A 包含 B 的所有字符
        // 在B的长度大于A长度时且能够满足题意A叠加后B成为其子串的，总共只有四种情况
        // 叠加n个A后刚好与B完全相等，例如A = 'ab', B = 'abab'，此时刚好只需要循环n次即可满足条件，循环更多次也只是重复无用功
        // 叠加n个A后与B的后部分完全相等，但此时B头部还有一小部分值刚好是A尾部分，例如A = 'ab', b = 'babab'，此时最少需要循环n + 1次才可满足条件
        // 同上一条，但多余部分出现在B的尾部，例如A = 'ab', b = 'ababa'，此时最少需要的循环次数同上
        // 同上，多余部分在B的头尾都有，例如A = 'ab', b = 'bababa'，此时最少需要的循环次数为n + 2次
        for (int i = 0; i <= B.length() / A.length() + 2; i++) {
            if (move.indexOf(B) >= 0) return counter;
            move.append(A);
            counter++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedStringMatch().repeatedStringMatch("abcd", "cdabcdab"));
    }
}
