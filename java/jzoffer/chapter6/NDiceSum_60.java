package chapter6;

import java.util.*;

public class NDiceSum_60 {

    public Map<Integer, Integer> recursion(int index) {
        Map<Integer, Integer> res = new HashMap<>();
        if (index == 1) {
            for (int i = 1; i <= 6; i++) {
                res.put(i, 1);
            }
            return res;
        }
        Map<Integer, Integer> next = recursion(index - 1);
        for (int i = 1; i <= 6; i++) {
            for (int j : next.keySet()) {
                res.put(i + j, res.getOrDefault(i + j, 0) + next.get(j));
            }
        }
        return res;
    }

    public double[] twoSum(int n) {
        if (n == 0) return new double[0];
        Map<Integer, Integer> res = recursion(n);
        double total = Math.pow(6, n);
        List<Double> doubleList = new ArrayList<>();
        for (int key = n; key <= 6 * n; key++) {
            doubleList.add(res.get(key) / total);
        }
        double[] returnValue = new double[doubleList.size()];
        for (int i = 0; i < returnValue.length; i++) {
            returnValue[i] = doubleList.get(i);
        }
        return returnValue;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NDiceSum_60().twoSum(2)));
    }

}
