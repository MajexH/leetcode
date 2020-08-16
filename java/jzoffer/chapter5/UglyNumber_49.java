package chapter5;

public class UglyNumber_49 {

    // 找到第 n 位的抽数
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        // 分别维护每一个 factor 的上一轮的最大的丑数
        int twoIndex = 0, threeIndex = 0, fiveIndex = 0;
        for (int i = 1; i < n; i++) {
            uglyNumbers[i] = Math.min(2 * uglyNumbers[twoIndex], Math.min(3 * uglyNumbers[threeIndex], 5 * uglyNumbers[fiveIndex]));
            while (2 * uglyNumbers[twoIndex] <= uglyNumbers[i]) {
                twoIndex++;
            }
            while (3 * uglyNumbers[threeIndex] <= uglyNumbers[i]) {
                threeIndex++;
            }
            while (5 * uglyNumbers[fiveIndex] <= uglyNumbers[i]) {
                fiveIndex++;
            }

        }

        return uglyNumbers[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumber_49().nthUglyNumber(10));
    }
}
