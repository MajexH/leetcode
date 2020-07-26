package highFrequency.math;

public class BinarySum {

    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int add = 0;
        while (i >= 0 || j >= 0) {
            int numA = i >= 0 ? a.charAt(i) - '0' : 0;
            int numB = j >= 0 ? b.charAt(j) - '0' : 0;
            int temp = numA + numB + add;
            add = temp / 2;
            builder.append(temp % 2);
            i--;
            j--;
        }
        if (add != 0) builder.append(add);
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new BinarySum().addBinary("1010", "1011"));
    }
}
