package str;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress_New {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        recursion(res, new ArrayList<>(), 0, s, 0);
        return res;
    }

    public void recursion(List<String> res, List<String> temp, int index, String str, int level) {
        if (level == 4) {
            if (index == str.length()) {
                res.add(String.join(".", temp));
            }
            return;
        }
        for (int i = index + 1; i <= Math.min(str.length(), index + 3); i++) {
            String number = str.substring(index, i);
            if (checkNumber(number)) {
                temp.add(number);
                recursion(res, temp, i, str, level + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean checkNumber(String number) {
        if (number.length() > 1 && number.startsWith("0")) return false;
        int temp = Integer.parseInt(number);
        return temp >= 0 && temp <= 255;
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIpAddress_New().restoreIpAddresses("25525511135"));
    }
}
