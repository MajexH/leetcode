import java.util.*;

public class RemoveKdigits_402 {

    public String removeKdigitsDeleteOne(String num, int k) {
        // 移除所有的数字
        if (k >= num.length()) return "0";
        while (k > 0) {
            num = deleteOne(num);
            k--;
        }
        // 去除前导 0
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < num.length()) {
            if (num.charAt(i) != '0') break;
            i++;
        }
        while (i < num.length()) {
            builder.append(num.charAt(i++));
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }

    private String deleteOne(String num) {
        for (int i = 1; i < num.length(); i++) {
            // 现在可以删除 i - 1 这个位置的数了
            if (num.charAt(i) < num.charAt(i - 1)) return num.substring(0, i - 1) + num.substring(i);
        }
        // 删除最后一个数字
        return num.substring(0, num.length() - 1);
    }

    // 移除 k 位数 使得 num 最小
    public String removeKdigits(String num, int k) {
        // 移除所有的数字
        if (k >= num.length()) return "0";
        // 删除数字的话 一定要删除的是 前面一个数字 大于 后面一个数字的地方
        // 因为这样才能在删除后保证剩下的形成更小的结果
        Deque<Character> queue = new LinkedList<>();
        for (char c : num.toCharArray()) {
            // 单调栈中保存之前的结果
            while (!queue.isEmpty() && queue.peekLast() > c && k > 0) {
                queue.removeLast();
                k--;
            }
            queue.add(c);
        }

        // 剩下的 一定是一个从小到大的序列
        while (k > 0) {
            k--;
            queue.removeLast();
        }

        StringBuilder builder = new StringBuilder();

        while (!queue.isEmpty()) {
            if (queue.peekFirst() == '0') queue.removeFirst();
            else break;
        }

        while (!queue.isEmpty()) {
            builder.append(queue.removeFirst());
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveKdigits_402().removeKdigitsDeleteOne("1432219", 3));
        System.out.println(new RemoveKdigits_402().removeKdigitsDeleteOne("10200", 1));
        System.out.println(new RemoveKdigits_402().removeKdigitsDeleteOne("10", 2));

    }
}
