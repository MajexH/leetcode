public class VerifyPostorder_33 {

    public boolean verifyPostorder(int[] postorder) {
        return recursion(postorder, 0, postorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean recursion(int[] postorder, int start, int end, int min, int max) {
        if (start >= end) return true;
        for (int i = start; i <= end; i++) {
            if (postorder[i] >= max || postorder[i] <= min) return false;
        }

        int root = postorder[end];
        int i = start;
        for (; i < end; i++) {
            if (postorder[i] > root) break;
        }

        return recursion(postorder, start, i - 1, min, root) && recursion(postorder, i, end - 1, root, max);
    }
}
