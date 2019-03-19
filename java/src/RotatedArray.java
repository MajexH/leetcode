import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RotatedArray {

    public static void rotate(int[] nums, int k) {
        int pre = nums.length - k;
        int[] preArray = Arrays.copyOfRange(nums, 0, pre - 1);
        int[] lastArray = Arrays.copyOfRange(nums, pre, nums.length);
        System.arraycopy(lastArray, 0, nums, );
    }

    public static void main(String[] args){

    }
}
