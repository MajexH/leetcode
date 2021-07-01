import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MaxLength_1239 {

    private int max;

    // 强行直接递归
    public int maxLength(List<String> arr) {
        List<String> notDuplicates = new ArrayList<>();
        for (String str : arr) {
            if (isUniqueString(str)) notDuplicates.add(str);
        }
        max = 0;
        recursion(notDuplicates, 0, new boolean[26]);
        return max;
    }

    private void recursion(List<String> arr, int index, boolean[] selected) {
        if (index == arr.size()) {
            int res = 0;
            for (boolean select : selected) {
                if (select) res++;
            }
            max = Math.max(max, res);
            return;
        }

        boolean flag = true;
        for (char c : arr.get(index).toCharArray()) {
            if (selected[c - 'a']) {
                flag = false;
                break;
            }
        }

        // 分别看选择或者不选择这个的结果
        if (flag) {
            boolean[] choose = new boolean[26];
            System.arraycopy(selected, 0, choose, 0, selected.length);
            for (char c : arr.get(index).toCharArray()) {
                choose[c - 'a'] = true;
            }
            recursion(arr, index + 1, choose);
        }

        recursion(arr, index + 1, selected);

    }

    private boolean isUniqueString(String str) {
        boolean[] memo = new boolean[26];

        for (char c : str.toCharArray()) {
            if (memo[c - 'a']) return false;
            memo[c - 'a'] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>(){{
            addAll(Arrays.asList("un","iq","ue"));
        }};
        System.out.println(new MaxLength_1239().maxLength(arr));
    }
}
