import java.util.Arrays;

public class LengthOfLongestSubstring_03 {

    public int lengthOfLongestSubstring(String s) {
        int[] preIndexes = new int[255];
        Arrays.fill(preIndexes, -1);
        int curLen = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (preIndexes[c] == -1 || curLen < i - preIndexes[c]) {
                curLen++;
            } else {
                curLen = i - preIndexes[c];
            }

            maxLen = Math.max(curLen, maxLen);
            preIndexes[c] = i;
        }
        return maxLen;
    }
}
