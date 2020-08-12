import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_22 {

    public void recursion(List<String> res, int left, int right, List<String> temp) {
        // 这相当于剩下的最括号比右括号少 是不可能的
        if (left > right) return;
        if (left == 0 && right == 0) {
            res.add(String.join("", temp));
            return;
        }
        if (left > 0) {
            temp.add("(");
            recursion(res, left - 1, right, temp);
            temp.remove(temp.size() - 1);
        }
        if (right > 0) {
            temp.add(")");
            recursion(res, left, right - 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recursion(res, n, n, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis_22().generateParenthesis(3));
    }
}
