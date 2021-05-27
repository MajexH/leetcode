public class HammingDistance_461 {

    // x & (x - 1) 可以不停的将最右边的1 变成 0
    public int hammingDistance(int x, int y) {
        int counter = 0;
        int xor = x ^ y;
        while (xor != 0) {

            xor &= (xor - 1);
            counter++;
        }
        return counter;
    }

    public int hammingDistanceBruteForce(int x, int y) {
        int counter = 0;

        while (x != y) {
            if ((x & 1) != (y & 1)) {
                counter++;
            }
            x >>= 1;
            y >>= 1;
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new HammingDistance_461().hammingDistance(4, 1));
    }
}
