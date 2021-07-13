public class HIndex_275 {

    public int hIndex(int[] citations) {
        int i = 0, j = citations.length - 1;
        // 找到最左的结果
        while (i < j) {
            int mid = i + (j - i) / 2;
            // 大于等于当前 mid 的论文数
            int counter = citations.length - mid;

            if (counter > citations[mid]) {
                // 说明不够
                // 右移
                i = mid + 1;
            } else {
                j = mid;
            }
        }

        return Math.min(citations.length - i, citations[i]);
    }

    public static void main(String[] args) {
        System.out.println(new HIndex_275().hIndex(new int[]{11,15}));
        System.out.println(new HIndex_275().hIndex(new int[]{1,2}));
        System.out.println(new HIndex_275().hIndex(new int[]{0}));
        System.out.println(new HIndex_275().hIndex(new int[]{0,0}));
        System.out.println(new HIndex_275().hIndex(new int[]{1,1,3}));
    }
}
