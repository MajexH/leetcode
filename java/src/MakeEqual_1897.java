public class MakeEqual_1897 {

    // 无限次的移动中间中的一个 word 的一个字母到另一个 word 中 问是否能够使得 words 中所有 word 相等
    public boolean makeEqual(String[] words) {
        int[] chars = new int[26];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                chars[c - 'a']++;
            }
        }

        int len = words.length;
        for (int counter : chars) {
            if (counter % len != 0) return false;
        }
        return true;
    }
}
