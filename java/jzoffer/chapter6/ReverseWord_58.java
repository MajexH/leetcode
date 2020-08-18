package chapter6;

public class ReverseWord_58 {

    public <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public <T> void reverse(T[] array) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }
    }

    public void reverse(char[] array) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }
    }

    public void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public String reverseWords(String s) {
        char[] str = s.trim().toCharArray();
        reverse(str);
        String[] temp = new String(str).split(" ");
        StringBuilder builder = new StringBuilder();
        for (String string : temp) {
            if (string.length() <= 0) continue;
            char[] tempChar = string.trim().toCharArray();
            reverse(tempChar);
            builder.append(new String(tempChar));
            builder.append(" ");
        }
        return builder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWord_58().reverseWords("a good   example"));
    }
}
