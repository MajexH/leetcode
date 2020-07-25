package chapter3;

import java.util.ArrayList;
import java.util.List;

public class PrintNumber_17 {

    /**
     * 给定一个 n 打印从 1 到 n位数的最大值的所有整数
     * 例如 n == 3 打印 1 到 999 的所有数
     * @param n
     * @return
     */
    public List<String> printNumber(int n) {
        List<String> res = new ArrayList<>();
        recursion(n, res, new ArrayList<>());
        return res;
    }

    // 去掉头部的 0
    public String getStr(List<Character> temp) {
        StringBuilder builder = new StringBuilder();
        boolean flag = true;
        for (char c : temp) {
            if (flag && c == '0') continue;
            flag = false;
            builder.append(c);
        }
        return builder.toString();
    }

    public void recursion(int n, List<String> res, List<Character> temp) {
        if (n == 0) {
            String tempStr = getStr(temp);
            if (tempStr.length() > 0)
                res.add(tempStr);
            return;
        }
        for (char i = '0'; i <= '9'; i++) {
            temp.add(i);
            recursion(n - 1, res, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new PrintNumber_17().printNumber(3));
    }
}
