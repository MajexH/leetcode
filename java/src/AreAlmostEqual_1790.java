import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AreAlmostEqual_1790 {

    // 判断两个字符串 最多执行一次交换就可以使其相等
    // 如 str1 = "bank", str2 = "kanb" 可以
    public boolean areAlmostEqual(String str1, String str2) {
        if (str1 == null || str2 == null) return false;
        if (str1.length() != str2.length()) return false;
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        Set<Integer>[] map2 = getMap(str2);

        boolean swapOnce = false;
        for (int i = 0; i < s1.length; i++) {
            char c1 = s1[i];
            char c2 = s2[i];
            // 这个时候说明要交换
            if (c1 != c2) {
                // 已经交换过一次了 下次还需要交换 就不成了
                if (swapOnce) return false;
                // 判断要交换的字母是否存在
                Set<Integer> c1InC2 = map2[c1 - 'a'];
                if (c1InC2.isEmpty()) return false;
                // 判断要交换的字母是否位置处在交换的位置上
                // 只要有一个位置满足就成
                for (int c1IndexInC2 : c1InC2) {
                    // 反查到 c1 中的位置 并判断两个字母是否相等
                    if (s1[c1IndexInC2] == c2) {
                        // str2 中的 i 位置 和 c1IndexInC2 这个位置的字母可以交换
                        // 交换字母顺序
                        map2[c2 - 'a'].remove(i);
                        map2[c2 - 'a'].add(c1IndexInC2);
                        map2[s1[c1IndexInC2] - 'a'].remove(c1IndexInC2);
                        map2[s1[c1IndexInC2] - 'a'].add(i);
                        swap(s2, i, c1IndexInC2);
                        swapOnce = true;
                        break;
                    }
                }
                // 如果上面没有找到能够交换的 说明要直接返回错误
                if (!swapOnce) return false;
            }
        }
        return true;
    }

    private void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private Set<Integer>[] getMap(String s) {
        // 只有小写字母
        Set<Integer>[] res = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            res[i] = new HashSet<>();
        }
        // 保存每个的位置
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - 'a'].add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new AreAlmostEqual_1790().areAlmostEqual("bank", "kanb"));
        System.out.println(new AreAlmostEqual_1790().areAlmostEqual("attack", "defend"));
        System.out.println(new AreAlmostEqual_1790().areAlmostEqual("kelb", "kelb"));
        System.out.println(new AreAlmostEqual_1790().areAlmostEqual("abcd", "dcba"));
    }
}
