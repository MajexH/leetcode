package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintNumbers_17 {

    public int[] printNumbers(int n) {
        double tmp = 1;
        for (int i = 0; i < n; i++) {
            tmp *= 10;
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < tmp - 1; i++) {
            res.add(i + 1);
        }
        int[] returnVal = new int[res.size()];

        for (int i = 0; i < returnVal.length; i++) {
            returnVal[i] = res.get(i);
        }

        return returnVal;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PrintNumbers_17().printNumbers(1)));
    }
}
