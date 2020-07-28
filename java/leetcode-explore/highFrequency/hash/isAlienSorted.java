package highFrequency.hash;

public class isAlienSorted {

    /**
     * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
     *
     * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
     *
     *
     * @param words 需要判断是否以 order 里面的字母顺序排列
     * @param order 给定的字母顺序
     * @return
     */
    public boolean isAlienSorted(String[] words, String order) {
        int[] orders = new int[26];
        // orders 表示字母出现的顺序
        for (int i = 0; i < order.length(); i++) {
            orders[order.charAt(i) - 'a'] = i;
        }
        // 现在只需要两个两个检查 是否是字典序排列 从小到大
        for (int i = 0; i < words.length - 1; i++) {
            // 前一个比后一个大 则不是字典序
            if (compareOneWordToAnother(words[i], words[i + 1], orders) > 0) return false;
        }
        return true;
    }

    // 根据给定的 orders 去判断 word1 和 word2 的大小
    public int compareOneWordToAnother(String word1, String word2, int[] orders) {
        int len1 = word1.length();
        int len2 = word2.length();
        for (int i = 0; i < Math.min(len1, len2); i++) {
            char w1 = word1.charAt(i);
            char w2 = word2.charAt(i);
            if (w1 != w2) {
                return orders[w1 - 'a'] - orders[w2 - 'a'];
            }
        }
        return len1 - len2;
    }

    public static void main(String[] args) {
        System.out.println(new isAlienSorted().isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(new isAlienSorted().isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(new isAlienSorted().isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
