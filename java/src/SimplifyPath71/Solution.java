package SimplifyPath71;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public String simplifyPath(String path) {
        List<String> res = new LinkedList<>();
        String[] origin = path.split("/");
        for (String item : origin) {
            if (item.equals(".") || item.length() == 0) {
                continue;
            }
            if (item.equals("..")) {
                if (res.size() != 0) {
                    res.remove(res.size() - 1);
                }
            } else {
                res.add(item);
            }
        }
        if (res.size() == 0) return "/";
        StringBuilder builder = new StringBuilder();
        for (String temp : res) {
            builder.append("/");
            builder.append(temp);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/a/../../b/../c//.//"));
    }

}
