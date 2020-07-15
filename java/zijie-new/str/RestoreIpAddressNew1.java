package str;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddressNew1 {

    public boolean checkValidIp(String str) {
        if (str.length() > 1 && str.startsWith("0")) return false;
        int temp = Integer.parseInt(str);
        return temp >= 0 && temp <= 255;
    }

    public void recursion(String s, int start, List<String> res, List<String> temp, int level) {
        if (level == 4) {
            if (start >= s.length()) {
                res.add(String.join(".", temp));
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) break;
            String tempStr = s.substring(start, start + i);
            if (checkValidIp(tempStr)) {
                temp.add(tempStr);
                recursion(s, start + i, res, temp, level + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        recursion(s, 0, res, new ArrayList<>(), 0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIpAddressNew1().restoreIpAddresses("25525511135"));
    }
}
