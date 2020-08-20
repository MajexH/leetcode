package chapter6;

public class CalculateSumWithoutControl_64 {

    public int sumNums(int n) {
        return recursion(n);
    }

    public int recursion(int n) {
        int sum = n;
        boolean x = n >= 1 && (sum += recursion(n - 1)) > 0;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new CalculateSumWithoutControl_64().sumNums(3));
    }
}
