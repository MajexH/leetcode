public class SumofTwoIntegers_371 {

    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = a ^ b;
            b = (temp & b) << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new SumofTwoIntegers_371().getSum(-2,3));
    }
}
