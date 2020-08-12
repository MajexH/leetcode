package algorithmInterview.hash;

public class TitleToNumber {

    /**
     * excel 列名称 to 序号
     * A -> 1
     * z -> 26
     * AA -> 27
     * 实际上是一个 26 进制的转化
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum * 26 + charToInteger(s.charAt(i));
        }
        return sum;
    }

    public int charToInteger(char c) {
        return c - 'A' + 1;
    }
}
