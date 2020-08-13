package chapter4;

public class VerifyBSTPostOrder_33 {

    public boolean recursion(int[] postorder, int start, int end, int max, int min) {
        if (start > end) return true;
        for (int i = start; i <= end; i++) {
            if (postorder[i] >= max || postorder[i] <= min) return false;
        }
        int rootVal = postorder[end];
        int i = end - 1;
        while (i >= start) {
             if (postorder[i] < rootVal) break;
             i--;
        }
        return recursion(postorder, start, i, rootVal, min) && recursion(postorder, i + 1, end - 1, max, rootVal);
    }

    public boolean verifyPostorder(int[] postorder) {
        return recursion(postorder, 0, postorder.length - 1, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static void main(String[] args) {
        System.out.println(new VerifyBSTPostOrder_33().verifyPostorder(new int[]{4,8,6,12,16,14}));
    }
}
