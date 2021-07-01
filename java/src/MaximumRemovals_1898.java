public class MaximumRemovals_1898 {

    public int maximumRemovals(String s, String p, int[] removable) {
        // 二分的搜索即可 因为如果删除 mid 地方的 removable 不行 那么 大于 mid 的也一定不行
        int i = 0, j = removable.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (check(s, p, removable, mid)) {
                // mid 加一是因为 长度为 下标加一
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return i;
    }

    private boolean check(String s, String p, int[] removable, int len) {
        int i = 0, j = 0;

        boolean[] removed = new boolean[s.length()];
        for (int z = 0; z <= len; z++) {
            removed[removable[z]] = true;
        }

        for (; i < s.length() && j < p.length(); i++) {
            if (removed[i]) continue;
            if (s.charAt(i) != p.charAt(j)) continue;
            j++;
        }

        return j == p.length();
    }

    public static void main(String[] args) {
        System.out.println(new MaximumRemovals_1898().maximumRemovals("abcacb", "ab", new int[]{3,1,0}));
        System.out.println(new MaximumRemovals_1898().maximumRemovals("abcbddddd", "abcd", new int[]{3,2,1,4,5,6}));
        System.out.println(new MaximumRemovals_1898().maximumRemovals("abcab", "abc", new int[]{0,1,2,3,4}));
    }
}
