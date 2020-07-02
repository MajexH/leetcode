public class RemoveOutermostParentheses_1021 {

    public String removeOuterParentheses(String S) {
        StringBuilder builder = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                if (level != 0) {
                    builder.append(c);
                }
                level++;
            } else if (c == ')') {
                if (level > 1) builder.append(c);
                level--;
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
