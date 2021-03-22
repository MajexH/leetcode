public class HammingWeight_191 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;

        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }
}
