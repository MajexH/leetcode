package str;

import java.util.LinkedList;

public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] origin = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        for (String temp : origin) {
            if (temp.length() == 0 || temp.equals(".")) continue;
            else if (temp.equals("..")) {
                if (stack.size() > 0) stack.removeLast();
            } else {
                stack.add(temp);
            }
        }
        if (stack.size() == 0) return "/";
        StringBuilder builder = new StringBuilder();
        for (String temp : stack) {
            builder.append("/");
            builder.append(temp);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPathNew().simplifyPath("/../"));
    }
}
