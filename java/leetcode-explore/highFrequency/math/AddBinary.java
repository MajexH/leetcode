package highFrequency.math;

public class AddBinary {

    public String addBinary(String a, String b) {
        int add = 0;
        StringBuilder builder = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            int num1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int num2 = j >= 0 ? b.charAt(j) - '0' : 0;

            int sum = num1 + num2 + add;
            add = sum / 2;
            builder.insert(0, (sum % 2));
            i--;
            j--;
        }
        if (add != 0) {
            builder.insert(0, add);
        }

        return builder.toString();
    }
}
