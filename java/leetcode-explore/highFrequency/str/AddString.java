package highFrequency.str;

public class AddString {

    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int add = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            int tmp = n1 + n2 + add;
            builder.insert(0, String.valueOf(tmp % 10));
            add = tmp / 10;
        }
        if (add != 0) {
            builder.insert(0, String.valueOf(add));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddString().addStrings("12", "449"));
        System.out.println(new AddString().addStrings("0", "0"));
    }
}
