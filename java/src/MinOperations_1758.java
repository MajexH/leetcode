public class MinOperations_1758 {

    public int minOperations(String s) {
        if (s.length() == 0) return 0;

        return Math.min(getRes(s, true), getRes(s, false));
    }

    public int getRes(String s, boolean isOne) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1' && !isOne) {
                res++;
            } else if (s.charAt(i) == '0' && isOne) {
                res++;
            }
            isOne = !isOne;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MinOperations_1758().minOperations("110010"));
        System.out.println(new MinOperations_1758().minOperations("0100"));
    }
}
