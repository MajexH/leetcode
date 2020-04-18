package str;

public class Multiply {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int add = 0;
        int[] a = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--){
            int numberI = char2Int(num1.charAt(i));
            for (int j = num2.length() - 1; j >= 0; j--) {
                int numberJ = char2Int(num2.charAt(j));
                int temp = (numberI * numberJ) + add + a[i + j + 1];
                a[i + j + 1] = temp % 10;
                add = temp / 10;
            }
            if (add != 0) {
                a[i] += add;
                add = 0;
            }
        }
        StringBuilder builder = new StringBuilder();
        boolean flag = true;
        for (int num : a) {
            if (flag && num == 0) continue;
            else {
                flag = false;
            }
            builder.append(num);
        }
        return builder.toString();
    }

    public int char2Int(char a) {
        return (int) a - 48;
    }

    public static void main(String[] args) {
        System.out.println(new Multiply().multiply("23", "4"));
    }
}
