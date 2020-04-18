package str;

public class reverseStr {

    public String reverseWords(String s) {
        String[] reverse = reverseStr(s.trim()).split(" ");
        StringBuilder builder = new StringBuilder();
        for (String temp : reverse) {
            if (temp.length() == 0) continue;
            builder.append(reverseStr(temp));
            builder.append(" ");
        }
        return builder.toString().trim();
    }

    public String reverseStr(String s) {
        StringBuilder builder = new StringBuilder(s);
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new reverseStr().reverseWords("a good   example"));
    }
}
