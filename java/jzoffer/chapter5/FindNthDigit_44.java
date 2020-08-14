package chapter5;

public class FindNthDigit_44 {

    // 数字以0123456789101112131415…的格式序列化到一个字符序列中。
    // 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
    //
    //请写一个函数，求任意第n位对应的数字。
    //
    /**
     * 0 - 9 包含 10 个数字 占 10位
     * 10 - 99 包含 90 个数字 占 180 位
     * 100 - 999 包含 900 个数字 占 2700 位
     * 因此要求 n 位数字 是那个的话 只需要定位他在那个区间的哪个数字上即可
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        long i = 1, t;
        // 首先找到剩下的位数
        while (n > (t = getDigits(i) * i)) {
            n -= t;
            i++;
        }
        // 找到剩下的位数 相当于 确定了 他在几位数的 范围内 并且他在这个范围内的哪个顺序上
        // index 表示 在这个范围内的哪个数字上
        long index = n / i;
        // numberIndex 表示这个数字的第几位
        long numberIndex = n % i;

        long beginNumber;
        if (i == 1) beginNumber = 0;
        else beginNumber = (int) Math.pow(10, i - 1);

        long currentNumber = beginNumber + index;
        return String.valueOf(currentNumber).charAt((int) numberIndex) - '0';

    }

    // 获得对应的位数
    // 1 的 话范围 10 位
    // 2 返回 90 位 数字
    public long getDigits(long number) {
        if (number == 1) return 10;
        return 9 * (long) Math.pow(10, number - 1);
    }

    public static void main(String[] args) {
        System.out.println(new FindNthDigit_44().findNthDigit(1000000000));
    }
}
