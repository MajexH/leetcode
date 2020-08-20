package chapter6;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ConstructProductArray_66 {

    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) return new int[0];
        int[] left = new int[a.length];
        left[0] = 1;
        for (int i = 1; i < a.length; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }

        int[] right = new int[a.length];
        right[a.length - 1] = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ConstructProductArray_66().constructArr(new int[]{1, 2, 3, 4, 5})));
    }
}
