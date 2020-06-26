package str;

import java.util.ArrayList;
import java.util.List;

/**
 * @author majexh
 */
public class RestoreIpAddress {

    public void recursion(String s, List<String> res, List<String> temp, int level, int start) {
        if (level == 4) {
            if (start == s.length()) {
                res.add(String.join(".", temp));
            }
            return;
        }

        for (int i = start + 1; i <= Math.min(s.length(), start + 3); i++) {
            String str = s.substring(start, i);
            if (checkValidIp(str)) {
                temp.add(str);
                recursion(s, res, temp, level + 1, i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean checkValidIp(String number) {
        if (number.length() > 1 && number.startsWith("0")) {
            return false;
        }
        int parseInt = Integer.parseInt(number);
        return parseInt >= 0 && parseInt <= 255;
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        recursion(s, res, new ArrayList<>(), 0, 0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIpAddress().restoreIpAddresses("25525511135"));
    }
}
