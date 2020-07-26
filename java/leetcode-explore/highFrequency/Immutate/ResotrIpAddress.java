package highFrequency.Immutate;

import java.util.ArrayList;
import java.util.List;

public class ResotrIpAddress {

    public void recursion(int index, String s, List<String> res, List<String> temp, int level) {
        if (level == 4) {
            if (index >= s.length()) {
                res.add(String.join(".", temp));
            }
            return;
        }
        for (int i = index + 1; i <= Math.min(index + 3, s.length()); i++) {
            String str = s.substring(index, i);
            if (validNumber(str)) {
                temp.add(str);
                recursion(i, s, res, temp, level + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean validNumber(String str) {
        if (str.length() > 1 && str.charAt(0) == '0') return false;
        int temp = Integer.parseInt(str);
        return temp >= 0 && temp <= 255;
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        recursion(0, s, res, new ArrayList<>(), 0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ResotrIpAddress().restoreIpAddresses("111111111111111111111111111111111"));
    }
}
