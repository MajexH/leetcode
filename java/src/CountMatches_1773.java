import java.util.List;

public class CountMatches_1773 {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        // 根据 rule key 确定 type
        int key;

        switch (ruleKey) {
            case "type":
                key = 0;
                break;
            case "color":
                key = 1;
                break;
            default:
                key = 2;
        }
        int res = 0;
        for (List<String> item : items) {
            if (item.get(key).equals(ruleValue)) {
                res++;
            }
        }
        return res;
    }
}
