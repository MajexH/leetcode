import java.util.Arrays;

public class Decode_1720 {

    public int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length + 1];
        res[0] = first;

        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] ^ encoded[i - 1];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Decode_1720().decode(new int[]{1, 2, 3}, 1)));
        System.out.println(Arrays.toString(new Decode_1720().decode(new int[]{6, 2, 7, 3}, 4)));
    }
}
