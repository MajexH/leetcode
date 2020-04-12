import java.util.LinkedList;

public class ValidateStackSequences_946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();
//        int i = 0, j = 0;
//        while (i < pushed.length) {
//            if (pushed[i] != popped[j]) {
//                stack.add(pushed[i]);
//            }
//            else {
//                // 找到第一个相同的元素 弹出
//                j++;
//                // 判断stack里面是否还有相同的元素
//                while (j < popped.length && stack.size() > 0 && stack.get(stack.size() - 1) == popped[j]) {
//                    stack.removeLast();
//                    j++;
//                }
//            }
//            i++;
//        }
//        if (stack.size() != popped.length - j) return false;
//        while (j < popped.length) {
//            if (stack.removeLast() != popped[j++]) return false;
//        }
//        return true;
        int i = 0;
        for (int push : pushed) {
            stack.add(push);
            while (!stack.isEmpty() && stack.get(stack.size() - 1) == popped[i]) {
                stack.removeLast();
                i++;
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(new ValidateStackSequences_946().validateStackSequences(new int[]{ 1,2,3,4,5 }, new int[]{ 4,3,5,1,2 }));
    }
}
