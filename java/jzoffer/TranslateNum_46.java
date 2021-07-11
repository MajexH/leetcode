public class TranslateNum_46 {

    public int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length() + 1];
        dp[str.length()] = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j <= Math.min(str.length(), i + 2); j++) {
                if (canTranslate(str, i, j)) {
                    dp[i] += dp[j];
                }
            }
        }
        return dp[0];
    }

    public boolean canTranslate(String num, int i, int j) {
        if (i >= j) return false;
        if (j - i > 1 && num.charAt(i) == '0') return false;
        int tmp = Integer.parseInt(num.substring(i, j));
        return tmp >= 0 && tmp <= 25;
    }

    public static void main(String[] args) {
        System.out.println(new TranslateNum_46().translateNum(12258));
    }
}
