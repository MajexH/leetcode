public class JudgeSquareSum_633 {

    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);

        while (i <= j) {
            int tmp = i * i + j * j;

            if (tmp > c) {
                j--;
            } else if (tmp < c) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new JudgeSquareSum_633().judgeSquareSum(5));
        System.out.println(new JudgeSquareSum_633().judgeSquareSum(3));
        System.out.println(new JudgeSquareSum_633().judgeSquareSum(4));
        System.out.println(new JudgeSquareSum_633().judgeSquareSum(2));
        System.out.println(new JudgeSquareSum_633().judgeSquareSum(1));
    }
}
