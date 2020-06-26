package interview;

public class First {

    // 找到股票的最大利润 （不是最大利润是多少 是最大利润的下标是多少）
    // [leetcode 股票的最大利润](...)
    public static void main(String[] args) {
        // 这个获取最大利润的下标就是 1 4 (在下标为 1 买入 下标为 4 卖出)
        int[] inputs = new int[]{ 7,4,5,3,6,1 };

        // minIndex 保存当前最小的值的位置
        int minIndex = -1;
        // maxIndex 保存当前最大的值得位置
        int maxIndex = -1;
        // 保存当前访问到的最大值
        int max = 0;
        // 保存返回的最大小值得位置
        int resMinIndex = -1, resMaxIndex = -1;
        for (int i = 0; i < inputs.length; i++) {
            if (minIndex == -1 || inputs[minIndex] > inputs[i]) {
                minIndex = i;
            }
            if (inputs[i] - inputs[minIndex] > max) {
                maxIndex = i;
                max = inputs[i] - inputs[minIndex];
                resMaxIndex = maxIndex;
                resMinIndex = minIndex;
            }
        }
        System.out.println(resMinIndex + " " + resMaxIndex);
    }
}
