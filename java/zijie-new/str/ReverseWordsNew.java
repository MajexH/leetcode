package str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author majexh
 */
public class ReverseWordsNew {

    public <T> void reverse(T[] array) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }

    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        List<String> res = new ArrayList<>(strs.length);

        reverse(strs);
        for (String str : strs) {
            if (str.length() > 0) {
                res.add(str);
            }
        }
        return String.join(" ", res);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsNew().reverseWords("    a good   example"));
    }
}
