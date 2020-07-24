package chapter2.str;

public class ReplaceBlank5 {

    /**
     * 将字符串中的空格替换成 %20
     * @param str
     * @return
     */
    public String replaceBlank(String str) {
        char[] origin = str.toCharArray();
        int blankCounter = 0;
        for (char c : origin) {
            if (c == ' ') blankCounter++;
        }
        char[] res = new char[origin.length + blankCounter * 2];

        for (int i = res.length - 1, j = origin.length - 1; i >= 0 && j >= 0;) {
            if (origin[j] == ' ') {
                res[i] = '0';
                res[i - 1] = '2';
                res[i - 2] = '%';
                i -= 3;
            } else {
                res[i] = origin[j];
                i--;
            }
            j--;
        }
        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(new ReplaceBlank5().replaceBlank("We are happy ! The"));
    }
}
