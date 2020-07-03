package math;

public class PowerOfTwo {

    public boolean iterative(int n) {
        double number = n;
        while (number > 1) {
            number /= 2;
        }
        return number == 1;
    }

    public boolean isPowerOfTwo(int n) {
        // return n > 0 && Integer.bitCount(n) == 1;
        // 这个地方其实 n & n - 1 其实是去掉了最后一位为1
        // 而如果是 2 的幂的话，则一定是 100000 这种形式
        // 按位于就是为 0
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfTwo().isPowerOfTwo(218));
        System.out.println(Math.abs((long) Integer.MIN_VALUE));
    }
}
