public class MergeAlternately_1768 {

    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        StringBuilder builder = new StringBuilder();
        int index = 0;
        while (i < word1.length() && j < word2.length()) {
            if ((index & 1) == 0) {
                builder.append(word1.charAt(i));
                i++;
            } else {
                builder.append(word2.charAt(j));
                j++;
            }
            index++;
        }
        if (i < word1.length()) {
            builder.append(word1.substring(i));
        }
        if (j < word1.length()) {
            builder.append(word2.substring(j));
        }
        return builder.toString();
    }

}
