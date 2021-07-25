public class GetLucky_5823 {

    public int getLucky(String s, int k) {
        StringBuilder builder = new StringBuilder();

        for (char c : s.toCharArray()) {
            builder.append(c - 'a' + 1);
        }
        String num = builder.toString();
        while (k > 0) {
            num = getSum(num);
            k--;
        }
        return Integer.parseInt(num);
    }

    private String getSum(String num) {

        long sum = 0;
        for (char c : num.toCharArray()) {
            int tmp = c - '0';
            sum += tmp;
        }
        return String.valueOf(sum);
    }
}
