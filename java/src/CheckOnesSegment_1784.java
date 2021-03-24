public class CheckOnesSegment_1784 {

    public boolean checkOnesSegment(String s) {
        if (s == null || s.length() == 0) return true;
        // 最多包含一串 11 组成的 否则返回 false

        // 是否在第一次遇见 1 的序列里面
        boolean first = true;
        // 之前已经找到了 1
        boolean foundOne = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                // 如果前面找到了 1 说明 first 已经完毕
                if (foundOne) first = false;
            } else if (s.charAt(i) == '1') {
                // 再次找到 1
                if (!first) return false;
                foundOne = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CheckOnesSegment_1784().checkOnesSegment("10011"));
        System.out.println(new CheckOnesSegment_1784().checkOnesSegment("00011100"));
        System.out.println(new CheckOnesSegment_1784().checkOnesSegment("01001"));
        System.out.println(new CheckOnesSegment_1784().checkOnesSegment("1001"));
        System.out.println(new CheckOnesSegment_1784().checkOnesSegment("110"));
    }
}
