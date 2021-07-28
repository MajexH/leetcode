public class MinPartitions_1689_New {

    // 里面最大的数 要有几个 1 构成
    public int minPartitions(String n) {
        int res = 0;

        for (char c : n.toCharArray()) {
            res = Math.max(res, c - '0');
        }
        return res;
    }
}
