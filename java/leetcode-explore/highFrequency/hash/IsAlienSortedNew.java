package highFrequency.hash;

public class IsAlienSortedNew {

    // 是否是按照 order 的顺序排列的
    public boolean isAlienSorted(String[] words, String o) {
        int[] order = new int[26];
        for (int i = 0; i < o.length(); i++) {
            // 保存他们的顺序
            order[o.charAt(i) - 'a'] = i;
        }

        // 查看 words 中的数据是否按照 order 的顺序进行排序
        return mergeSort(words, 0, words.length - 1, order);
    }

    // 比较的是从小到大 如果 str1 <= str2 返回 true
    private boolean cmp(String str1, String str2, int[] order) {
        int len = Math.min(str1.length(), str2.length());
        // 判断的逻辑是 只要前面的更小 它就应该排在前面
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                // 不等于就已经要返回了
                return order[str1.charAt(i) - 'a'] <= order[str2.charAt(i) - 'a'];
            }
        }
        return str1.length() <= str2.length();
    }

    public boolean mergeSort(String[] words, int i, int j, int[] order) {
        if (i >= j) return true;
        int mid = i + (j - i) / 2;

        boolean left = mergeSort(words, i, mid, order);
        if (!left) return false;
        boolean right = mergeSort(words, mid + 1, j, order);
        if (!right) return false;
        return merge(words, i, mid, j, order);
    }

    public boolean merge(String[] words, int start, int mid, int end, int[] order) {
        // 只判断是否失序算了
        int i = start, j = mid + 1;
        while (i <= mid && j <= end) {
            boolean flag = cmp(words[i], words[j], order);
            if (flag) {
                // words[i] <= words[j]
                i++;
            } else {
                j++;
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsAlienSortedNew().isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }
}
