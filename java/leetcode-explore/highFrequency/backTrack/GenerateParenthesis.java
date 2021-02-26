package highFrequency.backTrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recursion(n, n, "", res);
        return res;
    }

    public void recursion(int left, int right, String tmp, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(tmp);
            return;
        }
        if (left > 0) {
            recursion(left - 1, right, tmp + "(", res);
        }

        if (right > 0 && right > left) {
            recursion(left, right - 1, tmp + ")", res);
        }
    }
}
