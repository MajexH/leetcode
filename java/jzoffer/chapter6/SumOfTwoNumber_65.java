package chapter6;

public class SumOfTwoNumber_65 {

    public int add(int a, int b) {
        // 保存最后的结果
        int sum;
        // 保存进位
        int add;
        do {
            // 第一步先计算每位加起来在当为结果
            // 因为 0 + 0 1 + 1 都等于 0 0 + 1 和 1 + 0 的结果都为 1 因此用异或来计算
            sum = a ^ b;
            // 这个时候还要计算 进位是多少，只有一种情况会进位 就是在当前位上是 1 + 1 的情况
            add = (a & b) << 1;
            a = sum;
            b = add;
        } while (add != 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfTwoNumber_65().add(1,0));
    }
}
