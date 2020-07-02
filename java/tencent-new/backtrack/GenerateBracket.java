package backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateBracket {

    public void recursion(List<String> temp, int left, int right, List<String> res) {
        if (left <= 0 && right <= 0) {
            res.add(String.join("", temp));
            return;
        }
        if (left > 0) {
            temp.add("(");
            recursion(temp, left - 1, right, res);
            temp.remove(temp.size() - 1);
        }
        if (right > 0) {
            if (left < right) {
                temp.add(")");
                recursion(temp, left, right - 1, res);
                temp.remove(temp.size() - 1);
            }
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recursion(new ArrayList<>(), n, n, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new GenerateBracket().generateParenthesis(3));
    }
}
