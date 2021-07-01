public class IsNumber_20 {

    private static class Pair {
        boolean flag;
        int index;
        // 表示扫描的数字的数量
        int counter;

        public Pair(boolean flag, int index) {
            this.flag = flag;
            this.index = index;
        }
    }

    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) return false;
        int i = 0;
        Pair t = checkDecimal(s, i);
        if (t.index == s.length() || !t.flag) return t.flag;
        i = t.index;
        if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
            i++;
        } else {
            return false;
        }
        if (i == s.length()) return false;
        t = checkNumber(s, i);
        if (t.index == s.length()) return t.flag && t.counter > 0;
        return false;
    }

    private Pair checkNumber(String s, int index) {
        if (index == s.length()) return new Pair(true, index);
        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
            index++;
        }
        return checkUnsignedNumber(s, index);
    }

    private Pair checkUnsignedNumber(String s, int index) {
        Pair res = new Pair(false, index);
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c > '9' || c < '0') {
                res.index = index;
                return res;
            }
            res.counter++;
            index++;
        }
        res.flag = true;
        res.index = index;
        return res;
    }

    private Pair checkDecimal(String s, int index) {
        // 判断带符号整数的部分
        Pair pre = this.checkNumber(s, index);
        index = pre.index;
        if (index == s.length()) return new Pair(pre.flag, index);
        // . 前后至少要跟一个数字
        if (s.charAt(index) == '.') {
            index++;
        }
        Pair after = checkUnsignedNumber(s, index);
        if (pre.counter <= 0 && after.counter <= 0) return new Pair(false, after.index);
        return new Pair(true, after.index);
    }


    public static void main(String[] args) {
        System.out.println(new IsNumber_20().isNumber(" "));
    }
}
