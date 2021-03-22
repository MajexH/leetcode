public class CheckInclusion_567 {

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) return false;
        // 只要用一个数组来记录即可
        int[] memo = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            // 计算每一位的差值
            memo[s1.charAt(i) - 'a']--;
            memo[s2.charAt(i) - 'a']++;
        }
        // 表示有几位是不同的
        int diff = 0;
        // 计算 diff 值
        for (int count : memo) {
            // 如果所有差值为 0 说明这个地方是数量一样的
            if (count != 0) diff++;
        }

        if (diff == 0) return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            char leave = s2.charAt(i - s1.length()), add = s2.charAt(i);
            // 现在就要 从左边删除一个 从右边添加一个
            if (leave == add) {
                // 左右相等 diff 不会变
                continue;
            }

            // 删除 leave
            // 1. 如果 左侧的 leave 对应为 0 说明两个字符串在这儿的数字数量是相等的 减少一个 diff 需要++
            if (memo[leave - 'a'] == 0) diff++;
            // 相当于减少了一个 leave 的值
            memo[leave - 'a']--;
            // 2. 如果这个时候 修改后 为 0 说明相等 diff 就要减一
            if (memo[leave - 'a'] == 0) diff--;

            // 添加 add
            // 1. 如果这个时候右侧的差值等于0 说明 之前是相等的 但是现在加上 add 后需要 diff++
            if (memo[add - 'a'] == 0) diff++;
            // 添加 add
            memo[add - 'a']++;
            // 2. 或者添加完毕后为 0 说明之前不等 现在相等 diff--
            if (memo[add - 'a'] == 0) diff--;

            if (diff == 0) return true;
        }
        return false;
    }

    // 判断 s2 中的一个子串是否是 s1 的一个排列
    public boolean checkInclusionWithCheckTwoArray(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) return false;
        int[] mapForS1 = new int[26], mapForS2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            mapForS1[s1.charAt(i) - 'a']++;
            mapForS2[s2.charAt(i) - 'a']++;
        }

        boolean flag = isPermutation(mapForS1, mapForS2);

        for (int i = s1.length(); i < s2.length(); i++) {
            mapForS2[s2.charAt(i - s1.length()) - 'a']--;
            mapForS2[s2.charAt(i) - 'a']++;
            flag = flag || isPermutation(mapForS1, mapForS2);
        }
        return flag;
    }

    public boolean isPermutation(int[] mapForS1, int[] mapForS2) {
        for (int i = 0; i < mapForS1.length; i++) {
            if (mapForS1[i] != mapForS2[i]) return false;
        }
        return true;
    }
}
