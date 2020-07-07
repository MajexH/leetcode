package arrayandstr;

public class ReverseStrIII {

    public String reverseWords(String s) {
        s = reverse(s);
        String[] res = s.split(" ");
        for (int i = 0, j = res.length - 1; i < j;) {
            String temp = res[i];
            res[i] = res[j];
            res[j] = temp;
            i++;
            j--;
        }
        return String.join(" ", res);
    }

    public String reverse(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j;) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseStrIII().reverseWords("Let's take LeetCode contest"));
    }
}
