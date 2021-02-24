package highFrequency.str;

public class IntegerToEnglishNew {

    static String[] digital = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static String[] tens = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static String[] units = new String[]{"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        // 每次提取三位
        StringBuilder builder = new StringBuilder();
        int unitsIndex = 0;
        while (num > 0) {
            if (num % 1000 > 0) {
                String tmp = translateThreeNumber(num % 1000);
                builder.insert(0, tmp + " " + units[unitsIndex]);
            }
            unitsIndex++;
            num /= 1000;
        }
        return builder.toString().trim();
    }

    // 翻译一个长度为 3 的数字
    public String translateThreeNumber(int num) {
        // 不能超过
        if (num >= 1000 || num <= 0) {
            return "";
        }
        // 三位数
        if (num >= 100) {
            return " " + digital[num / 100 - 1] + " Hundred" + translateThreeNumber(num % 100);
        } else if (num >= 20) {
            return " " + tens[num / 10 - 2] + translateThreeNumber(num % 10);
        } else {
            return " " + digital[num - 1];
        }
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToEnglishNew().translateThreeNumber(611));
        System.out.println(new IntegerToEnglishNew().numberToWords(12345));
    }
}
