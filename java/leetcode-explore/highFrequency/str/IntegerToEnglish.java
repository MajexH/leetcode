package highFrequency.str;

import java.util.Arrays;

public class IntegerToEnglish {

    private static String[] Tens = { "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    private static String[] LessThan20 = { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven","Twelve", "Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private static String[] Units = { "", "Thousand", "Million", "Billion" };

    // 这样转换肯定是需要 3 个 3个 看成一堆进行转换
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder builder = new StringBuilder();
        // 相当于要每次取 3 位出来
        // 表示 units 的下标
        int index = 0;
        while (num > 0) {
            if (num % 1000 > 0) {
                // num % 1000 可以每次取出低三位
                // 这个是这个三位的英文表示
                String numberLimit3 = transNum2StrLimit3(num % 1000);
                builder.insert(0, numberLimit3 + Units[index] + " ");
            }
            index++;
            num /= 1000;
        }
        return builder.toString().trim();
    }

    // 将至多三位的数字转换成字母
    public String transNum2StrLimit3(int num) {
        if (num == 0) return "";
        StringBuilder builder = new StringBuilder();
        if (num < 20) {
            return builder.append(LessThan20[num - 1]).append(" ").toString();
        } else if (num < 100) {
            return builder.append(Tens[num / 10 - 2]).append(" ").append(transNum2StrLimit3(num % 10)).toString();
        } else {
            // 最大的就是三位数
            return builder.append(LessThan20[num / 100 - 1]).append(" Hundred ").append(transNum2StrLimit3(num % 100)).toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToEnglish().numberToWords(1234567891));
    }
}
