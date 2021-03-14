import java.util.Deque;
import java.util.LinkedList;

public class IsValidSerialization_331 {

    // 验证二叉树的前序序列化 null 节点用 # 表示
    // 给定的 preorder 是前序遍历的一个节点
    public boolean isValidSerialization(String preorder) {

        String[] strs = preorder.split(",");

        int len = strs.length;

        if (len == 1 && strs[0].equals("#")) return true;

        Deque<String> stack = new LinkedList<>();

        // 优化一下这儿的代码
        for (String str : strs) {
            // 如果不是 # 直接入栈即可
            if (!str.equals("#")) {
                stack.addLast(str);
                continue;
            }
            // 加入一个 null 节点，如果这个时候栈为空 相当于没有父节点是不能的 返回 false
            if (stack.size() == 0) return false;
            // 找到两个连续的 null 节点 但是 stack 为空 也是不可能
            if (stack.getLast().equals("#")) {
                while (stack.size() > 0 && stack.getLast().equals("#")) {
                    stack.removeLast();
                    if (stack.size() == 0) return false;
                    stack.removeLast();
                }
                // 这个地方要多次弹出 stack 的最后一个 不为 #
                stack.add("#");
                continue;
            }
            // 这个时候 不是空 直接加入
            stack.addLast(str);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }

    public static void main(String[] args) {
        System.out.println(new IsValidSerialization_331().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(new IsValidSerialization_331().isValidSerialization("1,#"));
        System.out.println(new IsValidSerialization_331().isValidSerialization("9,#,#,1"));
        System.out.println(new IsValidSerialization_331().isValidSerialization("1,#,#,#,#"));
        System.out.println(new IsValidSerialization_331().isValidSerialization("#"));
    }
}
