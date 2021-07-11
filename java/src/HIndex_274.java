import java.util.Arrays;

public class HIndex_274 {

    // h 表示的 至少有 h 篇论文被引用了 h 次
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        // 先从小到大排序
        Arrays.sort(citations);

        int res = 0;
        int total = citations.length;

        for (int i = citations.length - 1; i >= 0; i--) {
            // 这个 i 后面又多少个 后面的 一定比前面的多
            int atLeast = total - i;
            int mayBeRes = Math.min(atLeast, citations[i]);
            res = Math.max(res, mayBeRes);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new HIndex_274().hIndex(new int[]{3,0,6,1,5}));
    }
}
