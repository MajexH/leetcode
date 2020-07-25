package str;

public class StrPermutationNew {

    public boolean checkInclusion(String s1, String s2) {
        // 子串比原来的串长是不可能的
        if (s1.length() > s2.length()) return false;
        int[] memoForS1 = new int[26];
        int[] memoForS2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            memoForS1[s1.charAt(i) - 'a']++;
            memoForS2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (checkMemo(memoForS1, memoForS2)) return true;
            memoForS2[s2.charAt(i) - 'a']--;
            memoForS2[s2.charAt(i + s1.length()) - 'a']++;
        }
        return checkMemo(memoForS1, memoForS2);
    }

    public boolean checkMemo(int[] memoForS1, int[] memoForS2) {
        for (int i = 0; i < 26; i++) {
            if (memoForS1[i] != memoForS2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new StrPermutationNew().checkInclusion("ab", "eidboaooo"));
    }
}
