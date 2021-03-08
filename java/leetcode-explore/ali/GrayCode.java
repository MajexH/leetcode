package ali;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GrayCode {

    public List<Integer> grayCode(int n) {
        int len = (int) Math.pow(2, n);
        int[] res = new int[len];
        for (int i = 1; i < len; i++) {
            res[i] = i ^ (i >> 1);
        }

        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(new GrayCode().grayCode(2));
    }
}
