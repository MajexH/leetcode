public class TitleToNumber_171 {

    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (char c : columnTitle.toCharArray()) {
            res = res * 26 + getNumber(c);
        }
        return res;
    }

    private int getNumber(char c) {
        return c - 'A' + 1;
    }
}
