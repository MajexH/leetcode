public class SecondHighest_1796 {

    // 找到 从大到小的第二大的数字
    public int secondHighest(String s) {
        if (s == null || s.length() == 0) return -1;
        Integer max = null, less = null;

        for (char c : s.toCharArray()) {
            if (c < '0' || c > '9') continue;
            int n = c - '0';
            if (max == null || max == n) {
                max = n;
            } else if (less == null) {
                less = Math.min(max, n);
                max = Math.max(max, n);
            } else {
                if (n > max) {
                    less = max;
                    max = n;
                } else if (n > less) {
                    less = n;
                }
            }
        }
        return less == null ? -1 : less;
    }

    public static void main(String[] args) {
        System.out.println(new SecondHighest_1796().secondHighest("ck077"));
        System.out.println(new SecondHighest_1796().secondHighest("abc111"));
    }
}
