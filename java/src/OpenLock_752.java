import java.util.*;
import java.util.stream.Collectors;

public class OpenLock_752 {

    private static int[] nums = new int[]{1, -1};

    // 广搜问题
    public int openLock(String[] deadends, String target) {
        Deque<String> strs = new LinkedList<>();
        Deque<Integer> indexes = new LinkedList<>();

        Set<String> deadEndsSet = Arrays.stream(deadends).collect(Collectors.toSet());
        Set<String> memo = new HashSet<>();
        if (deadEndsSet.contains("0000")) return -1;
        if (target.equals("0000")) return 0;
        strs.add("0000");
        memo.add("0000");
        indexes.add(0);
        while (!strs.isEmpty()) {
            String top = strs.removeFirst();
            int index = indexes.removeFirst();

            // 最小旋转次数的话 就是
            // 每一个位数 加 1 看看是不是想要在 target 里面 且是不是 target
            for (int i = 0; i < top.length(); i++) {
                for (int num : nums) {
                    int tmp = top.charAt(i) - '0' + num;
                    if (tmp >= 10) tmp = 0;
                    if (tmp <= 0) tmp = 9;
                    String added = top.substring(0, i) + tmp + top.substring(i + 1);
                    if (deadEndsSet.contains(added) || memo.contains(added)) continue;
                    if (added.equals(target)) {
                        return index + 1;
                    }
                    memo.add(added);
                    strs.add(added);
                    indexes.add(index + 1);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new OpenLock_752().openLock(new String[]{"0201","0101","0102","1212","2002"}, "0000"));
    }

}
