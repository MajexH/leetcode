package highFrequency.str;

import java.util.Arrays;

public class ReorderLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (str1, str2) -> {
            // limit == 2 表示会分割成两个
            String[] strs1 = str1.split(" ", 2);
            String[] strs2 = str2.split(" ", 2);
            // 字母 排在数字前
            String flagStr1 = strs1[1];
            String flagStr2 = strs2[1];
            if (checkNumber(flagStr1) && checkAlpha(flagStr2)) return 1;
            else if (checkAlpha(flagStr1) && checkNumber(flagStr2)) return -1;
            else {
                // 这时候两个应该是同一种类型的
                // 如果都是字母 按照去除头的字母顺序排序
                if (checkAlpha(flagStr1)) {
                    int cmp = strs1[1].compareTo(strs2[1]);
                    if (cmp == 0) {
                        return strs1[0].compareTo(strs2[0]);
                    } else {
                        return cmp;
                    }
                }
            }
            return 0;
        });
        return logs;
    }

    public boolean checkNumber(String str) {
        return str.charAt(0) >= '0' && str.charAt(0) <= '9';
    }

    public boolean checkAlpha(String str) {
        String temp = str.toLowerCase();
        return temp.charAt(0) >= 'a' && temp.charAt(0) <= 'z';
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new ReorderLogFiles().reorderLogFiles(new String[]{"g1 act car","a2 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"})));
        //String a = "a b c d d d e";
        //System.out.println(Arrays.toString(a.split(" ", 2)));
    }
}
