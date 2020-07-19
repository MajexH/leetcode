package str;

public class StrPermutation {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] memoForS1 = new int[26];
        int[] memoForS2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            memoForS1[s1.charAt(i) - 'a']++;
        }

        for (int j = 0; j < s1.length(); j++) {
            memoForS2[s2.charAt(j) - 'a']++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (checkMap(memoForS1, memoForS2)) return true;
            memoForS2[s2.charAt(i) - 'a']--;
            memoForS2[s2.charAt(i + s1.length()) - 'a']++;
        }
        return checkMap(memoForS1, memoForS2);
    }

    public boolean checkMap(int[] memoForS1, int[] memoForS2) {
        for (int i = 0; i < 26; i++) {
            if (memoForS1[i] != memoForS2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new StrPermutation().checkInclusion("adc", "dcda"));
    }
}
