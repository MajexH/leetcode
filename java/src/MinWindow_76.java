public class MinWindow_76 {

    // s 中涵盖 t 的最小覆盖串
    public String minWindow(String s, String t) {
        // 边界条件
        if (s == null || t == null) return "";
        // t 串比 s 串长 一定在 s 中找不到 t
        if (s.length() < t.length()) return "";
        // 返回结果
        String res = "";

        // 初始化
        // 因为 整个字符串只包含英文 所以 可以直接用 ascii 码表 表示 长度 255
        int[] mapForT = new int[255];
        for (char c : t.toCharArray()) {
            mapForT[c]++;
        }
        // s 串的 map 只需要初始化到 t 串长度即可
        int[] mapForS = new int[255];
        for (int i = 0; i < t.length(); i++) {
            mapForS[s.charAt(i)]++;
        }

        int left = 0, right = t.length();

        // 首先比较 初始化后 t 长度的是否已经满足
        if (isEqualMap(mapForT, mapForS)) {
            res = s.substring(0, t.length());
        }

        while (right < s.length()) {
            // 添加一个新的字符到 s 串的 map 中
            mapForS[s.charAt(right)]++;
            // 如果窗口的子串 满足要求
            while (left <= right && isEqualMap(mapForT, mapForS)) {
                // 更新结果字符串
                if (res.length() == 0 || res.length() > right - left + 1) {
                    res = s.substring(left, right + 1);
                }
                // 这个时候删除左字符串 缩小范围
                mapForS[s.charAt(left++)]--;
            }
            right++;
        }

        return res;
    }

    // 判断 map 是否一样
    public boolean isEqualMap(int[] mapForT, int[] mapForS) {
        for (int i = 0; i < 255; i++) {
            // 如果 t 中存在的字符 在 s 中不存在 说明不能组成 t
            if (mapForT[i] != 0) {
                if (mapForS[i] < mapForT[i]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new MinWindow_76().minWindow("aa", "a"));
//        System.out.println(new MinWindow_76().minWindow("ADOBECODEBANC", "ABC"));
    }
}
