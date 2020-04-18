package str;

import java.util.ArrayList;
import java.util.List;

public class RestoreIp {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        recursion(s, 0, new ArrayList<>(), res, 0);
        return res;
    }

    public void recursion(String s, int index, List<String> temp, List<String> res, int level) {
        if (level == 4) {
            if (index == s.length())
                res.add(String.join(".", temp));
            return;
        }
        for (int j = index + 1; j <= Math.min(index + 3, s.length()); j++) {
            String tmpStr = s.substring(index, j);
            if (validIp(tmpStr)) {
                temp.add(tmpStr);
                recursion(s, j, temp, res, level + 1);
                temp.remove(temp.size() - 1);
            }
        }

    }

    public boolean validIp(String s) {
        if (s.length() > 1 && s.startsWith("0")) return false;
        int temp = Integer.parseInt(s);
        return temp >= 0 && temp <= 255;
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIp().restoreIpAddresses("25525511135"));
    }
}
