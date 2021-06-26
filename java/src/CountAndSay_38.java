import java.util.ArrayList;
import java.util.List;

public class CountAndSay_38 {

    private static List<String> res = new ArrayList<>();
    static {
        res.add("0");
        res.add("1");
    }
    // 外观数组
    public String countAndSay(int n) {
        if (res.size() > n) {
            return res.get(n);
        }

        for (int i = res.size(); i <= n; i++) {
            String pre = res.get(i - 1);
            res.add(getNext(pre));
        }

        return res.get(n);
    }

    private String getNext(String str) {
        StringBuilder builder = new StringBuilder();

        int pre = 0;
        char cur = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (cur != str.charAt(i)) {
                builder.append(i - pre);
                builder.append(cur);

                cur = str.charAt(i);
                pre = i;
            }
        }
        builder.append(str.length() - pre);
        builder.append(cur);
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay_38().countAndSay(1));
        System.out.println(new CountAndSay_38().countAndSay(2));
        System.out.println(new CountAndSay_38().countAndSay(3));
        System.out.println(new CountAndSay_38().countAndSay(4));
        System.out.println(new CountAndSay_38().countAndSay(5));
        System.out.println(new CountAndSay_38().countAndSay(6));
        System.out.println(new CountAndSay_38().countAndSay(7));
    }
}
