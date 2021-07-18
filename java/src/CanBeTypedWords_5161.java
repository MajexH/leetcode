import java.util.HashSet;
import java.util.Set;

public class CanBeTypedWords_5161 {

    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> brokenLetterSet = new HashSet<>();

        for (char c : brokenLetters.toCharArray()) {
            brokenLetterSet.add(c);
        }
        String[] splited = text.trim().split(" ");
        int broken = 0;
        for (String tmp : splited) {
            for (char c : tmp.toCharArray()) {
                if (brokenLetterSet.contains(c)) {
                    broken++;
                    break;
                }
            }
        }

        return splited.length - broken;
    }
}
