public class ShiftingLetters_848 {

    public String shiftingLetters(String S, int[] shifts) {
        long[] mv = new long[shifts.length];
        for (int i = shifts.length - 1; i >= 0; i--) {
            mv[i] = i == shifts.length - 1 ? shifts[i] : mv[i + 1] + shifts[i];
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            int c = S.charAt(i) - 'a';
            char r = (char) (((c + mv[i]) % 26) + 'a');
            builder.append(r);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ShiftingLetters_848().shiftingLetters("abc", new int[]{505870226,579874654,9}));
    }
}
