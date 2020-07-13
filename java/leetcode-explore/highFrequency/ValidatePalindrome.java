package highFrequency;

public class ValidatePalindrome {

    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char left = s.charAt(i), right = s.charAt(j);
            if (left < '0' || (left > '9' && left < 'A') || (left > 'Z' && left < 'a') || left > 'z') {
                i++;
                continue;
            }
            if (right < '0' || (right > '9' && right < 'A') || (right > 'Z' && right < 'a') || right > 'z') {
                j--;
                continue;
            }
            if (left != right && !(Math.min(left, right) >= 'A' && Math.abs(left - right) == 32)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(new ValidatePalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
