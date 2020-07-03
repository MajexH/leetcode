package math;

public class PalindromeNumber {

    public boolean stringCheck(int x) {
        String temp = String.valueOf(x);
        int i = 0, j = temp.length() - 1;
        while (i < j) {
            if (temp.charAt(i) != temp.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public boolean notUseString(int x) {
        if (x < 0) return false;
        int reverseNumber = 0, record = x;
        while (x > 0) {
            reverseNumber = reverseNumber * 10 + x % 10;
            x = x / 10;
        }
        return record == reverseNumber;
    }

    public boolean isPalindrome(int x) {
        return notUseString(x);
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(134));
    }
}
