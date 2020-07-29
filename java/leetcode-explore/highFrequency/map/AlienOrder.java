package highFrequency.map;

import java.util.*;

public class AlienOrder {

    // 拓扑排序
    public String alienOrder(String[] words) {
        // 邻接表
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            String str1 = words[i], str2 = words[i + 1];
            int length1 = str1.length(), length2 = str2.length();
            // 如果前面一个比后面一个短 而且他们在长度相同的部分还是一样的 则说明是不可能的 直接返回空 如 {abc,ab}
            boolean flag = true;
            // 构建图的邻接表
            for (int j = 0; j < Math.min(length1, length2); j++) {
                if (str1.charAt(j) == str2.charAt(j)) continue;
                flag = false;
                Set<Character> temp = map.getOrDefault(str1.charAt(j), new HashSet<>());
                temp.add(str2.charAt(j));
                map.put(str1.charAt(j), temp);
                break;
            }
            // flag 为true说明这两个字符串一定是相等的这是时候如果前一个比后一个常 说明不可能
            if (flag && length1 - length2 > 0) return "";
        }

        // 构建入度 不存在的character 认为是 -1
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);
        // 初始化 入度 数组为0 因为只有部分字母存在
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree[c - 'a'] = 0;
            }
        }
        // 初始化入度
        for (char key : map.keySet()) {
            for (char val : map.get(key)) {
                indegree[val - 'a']++;
            }
        }
        Queue<Character> indegreesEqualsZero = new LinkedList<>();

        // 图中所有的节点
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (indegree[i] != -1) count++;
            if (indegree[i] == 0) {
                indegreesEqualsZero.add((char) ('a' + i));
            }
        }

        StringBuilder builder = new StringBuilder();

        while (indegreesEqualsZero.size() > 0) {
            char top = indegreesEqualsZero.poll();
            builder.append(top);
            for (char c : map.getOrDefault(top, new HashSet<>())) {
                indegree[c - 'a']--;
                if (indegree[c - 'a'] == 0) indegreesEqualsZero.add(c);
            }
        }

        // 说明节点上有环
        if (builder.length() != count) return "";
        else return builder.toString();
    }

    /**
     * 现有一种使用字母的全新语言，这门语言的字母顺序与英语顺序不同。
     *
     * 假设，您并不知道其中字母之间的先后顺序。但是，会收到词典中获得一个 不为空的 单词列表。因为是从词典中获得的，所以该单词列表内的单词已经 按这门新语言的字母顺序进行了排序。
     *
     * 您需要根据这个输入的列表，还原出此语言中已知的字母顺序。
     *
     * 也就是根绝已经排序的数组 反推他的排序的依据
     *
     * 这是个 拓扑排序 我现在的做法是无法解决 z -> z 这种情况的
     * @param words
     * @return
     */
    public String alienOrder1(String[] words) {
        // map[i] 表示 words.charAt(i) - '0' 这个下标位置的下一个字母
        int[] map = new int[26];
        Arrays.fill(map, -1);
        // 保存子节点的下标 方便找到最开始的头结点
        Set<Integer> memo = new HashSet<>();
        for (int i = 0; i < words.length - 1; i++) {
            Pair p = compareTwoStr(words[i], words[i + 1]);
            // 表示找不到
            if (p.pre == -1) continue;
            // 将父节点指向子节点
            map[p.pre - 'a'] = p.last - 'a';
            memo.add(p.last - 'a');
        }
        int start = -1;
        for (int i = 0; i < map.length; i++) {
            if (!memo.contains(i) && map[i] != -1) {
                start = i;
                break;
            }
        }
        if (start == -1) return "";
        StringBuilder builder = new StringBuilder();
        while (start != -1) {
            builder.append((char) (start + 'a'));
            start = map[start];
        }

        return builder.toString();
    }

    private static class Pair {
        int pre;
        int last;

        public Pair(int pre, int last) {
            this.pre = pre;
            this.last = last;
        }
    }
    /**
     * 用前一个数比上后一个数
     * 找到他们对应下标不同的一个char 说明前一个数的char的字典序在后一个char之前
     * 或者这个时候 他们所有的字符都相等 那就返回 -1
     * @param str1
     * @param str2
     * @return
     */
    public Pair compareTwoStr(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        for (int i = 0; i < Math.min(len1, len2); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return new Pair(str1.charAt(i), str2.charAt(i));
            }
        }
        // 说明两个string是相等的 这个时候就无法判断
        return new Pair(-1, -1);
    }

    public static void main(String[] args) {
        System.out.println(new AlienOrder().alienOrder(new String[]{ "abc","ab" }));
    }
}
