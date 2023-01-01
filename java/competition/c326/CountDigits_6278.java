package competition.c326;

public class CountDigits_6278 {

    public int countDigits(int num) {

        int res = 0;
        int tmp = num;
        while (tmp != 0) {

            if (num % (tmp % 10) == 0) {
                res++;
            }
            tmp /= 10;
        }

        return res;
    }
}
