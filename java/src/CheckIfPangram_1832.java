import java.util.HashSet;
import java.util.Set;

public class CheckIfPangram_1832 {

    static int mod = 0;

    static {
        for (int i = 0; i < 26; i++) {
            mod = mod | (1 << i);
        }
    }

    public boolean checkIfPangram(String sentence) {
        // 尝试下 bitmap 的做法
        int res = 0;

        for (char c : sentence.toCharArray()) {
            int i = c - 'a';
            res = res | (1 << i);
            if ((mod & res) == mod) return true;
        }
        return false;
    }

    public boolean checkIfPangramUseSet(String sentence) {
        Set<Character> set = new HashSet<>();

        for (char c : sentence.toCharArray()) {
            set.add(c);
            if (set.size() == 26) return true;
        }
        return false;
    }
}
