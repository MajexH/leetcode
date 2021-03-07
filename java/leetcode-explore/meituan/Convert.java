package meituan;

public class Convert {

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }

        int row = 0;
        boolean down = true;
        for (int i = 0; i < s.length(); i++) {
            builders[row].append(s.charAt(i));
            if (down) row++;
            else row--;
            if (row % (numRows - 1) == 0) down = !down;
        }
        StringBuilder builder = new StringBuilder();
        for (StringBuilder b : builders) {
            builder.append(b.toString());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Convert().convert("PAYPALISHIRING", 3));
        System.out.println(new Convert().convert("PAYPALISHIRING", 4));
    }
}
