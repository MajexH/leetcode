package chapter2.str;

public class ReplaceSpace_5 {

    public String replaceSpace(String s) {
        int spaces = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') spaces++;
        }

        char[] res = new char[s.length() + 2 * spaces];

        for (int i = res.length - 1, j = s.length() - 1; j >= 0; j--, i--) {
            if (s.charAt(j) != ' ') {
                res[i] = s.charAt(j);
                continue;
            }
            res[i] = '0';
            res[--i] = '2';
            res[--i] = '%';
        }

        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(new ReplaceSpace_5().replaceSpace("We are happy."));
    }
}
