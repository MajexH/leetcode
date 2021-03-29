import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Evaluate_1807 {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();

        for (List<String> k : knowledge) {
            map.put(k.get(0), k.get(1));
        }
        StringBuilder res = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        boolean after = false;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                after = true;
                continue;
            } else if (c == ')') {
                after = false;
                String key = builder.toString();
                builder.delete(0, builder.length());
                res.append(map.getOrDefault(key, "?"));
                continue;
            }
            if (after) builder.append(c);
            else {
                res.append(c);
            }
        }
        return res.toString();
    }

}
