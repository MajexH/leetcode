import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath_71 {

    public String simplifyPath(String path) {
        String[] paths = path.split("/");

        Deque<String> res = new LinkedList<>();

        for (String p : paths) {
            if (p.length() == 0 || p.equals(".")) continue;

            if (p.equals("..")) {
                if (!res.isEmpty()) {
                    res.removeLast();
                }
                continue;
            }

            res.add(p);
        }

        if (res.size() == 0) return "/";
        StringBuilder builder = new StringBuilder();
        while (!res.isEmpty()) {
            builder.append('/');
            builder.append(res.removeFirst());
        }
        return builder.toString();
    }
}
