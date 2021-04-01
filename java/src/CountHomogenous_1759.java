public class CountHomogenous_1759 {

    public int countHomogenous(String s) {
        int res = 0;
        int preIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(preIndex)) {
                int len = i - preIndex;
                preIndex = i;
                long tmp = (long) (len + 1) * len / 2;
                res = (int) ((res + (tmp % 1000000007)) % 1000000007);
            }
        }
        int len = s.length() - preIndex;
        long tmp = (long) (len + 1) * len / 2;
        res = (int) ((res + (tmp % 1000000007)) % 1000000007);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CountHomogenous_1759().countHomogenous("abbcccaa"));
        System.out.println(new CountHomogenous_1759().countHomogenous("xy"));
        System.out.println(new CountHomogenous_1759().countHomogenous("zzzzz"));
    }
}
