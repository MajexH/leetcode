import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_new_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recursion(res, n, n, "");
        return res;
    }

    public void recursion(List<String> res, int left, int right, String tmp) {
        if (left == 0 && right == 0) {
            res.add(tmp);
            return;
        }

        if (left > 0) {
            recursion(res, left - 1, right, tmp + "(");
        }
        if (right > left) {
            recursion(res, left, right - 1, tmp + ")");
        }
    }
}