import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationWithStr {

    public void permutate(List<String> res, String[] chars, int start) {
        if (start == chars.length) {
            res.add(String.join("", chars));
            return;
        }
        for (int i = start; i < chars.length; i++) {
            swap(chars, i, start);
            permutate(res, chars, start + 1);
            swap(chars, i, start);
        }
    }

    public void swap(String[] chars, int i, int j) {
        String temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public String[] permutation(String S) {
        List<String> res = new ArrayList<>();
        String[] chars = S.split("");
        permutate(res, chars, 0);
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PermutationWithStr().permutation("qwe")));
    }
}
