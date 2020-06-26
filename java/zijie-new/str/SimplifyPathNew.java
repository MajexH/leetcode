package str;

import java.util.LinkedList;

/**
 * @author majexh
 */
public class SimplifyPathNew {

    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();

        String[] paths = path.split("/");

        for (String temp : paths) {
            if (temp.length() <= 0 || ".".equals(temp)) {
                continue;
            } else if ("..".equals(temp)) {
                if (stack.size() > 0) {
                    stack.removeLast();
                }
            } else {
                stack.addLast(temp);
            }
        }
        if (stack.size() == 0) {
            return "/";
        } else {
            StringBuilder builder = new StringBuilder();
            for (String temp : stack) {
                builder.append("/");
                builder.append(temp);
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPathNew().simplifyPath("/a//b////c/d//././/.."));
    }
}
